package com.demo.ewalletshopping.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.ewalletshopping.constants.ApplicationConstants;
import com.demo.ewalletshopping.dao.CartDao;
import com.demo.ewalletshopping.dao.CartDetailDao;
import com.demo.ewalletshopping.dao.OrderConfirmationDao;
import com.demo.ewalletshopping.dao.UserDao;
import com.demo.ewalletshopping.dao.WalletDao;
import com.demo.ewalletshopping.dto.OrderHistoryDto;
import com.demo.ewalletshopping.dto.OrderHistoryResponseDto;
import com.demo.ewalletshopping.dto.OrderRequestDto;
import com.demo.ewalletshopping.dto.OrderResponseDto;
import com.demo.ewalletshopping.exception.BalanceInsufficientException;
import com.demo.ewalletshopping.exception.CartNotFoundException;
import com.demo.ewalletshopping.exception.NoOrdersFoundException;
import com.demo.ewalletshopping.exception.UserNotFoundException;
import com.demo.ewalletshopping.exception.WalletNotFoundException;
import com.demo.ewalletshopping.model.Cart;
import com.demo.ewalletshopping.model.CartDetail;
import com.demo.ewalletshopping.model.OrderConfirmation;
import com.demo.ewalletshopping.model.Product;
import com.demo.ewalletshopping.model.User;
import com.demo.ewalletshopping.model.Wallet;
import com.demo.ewalletshopping.service.CartService;
import com.demo.ewalletshopping.service.OrderConfirmationService;
import com.demo.ewalletshopping.service.WalletService;

/**
 * @author Lahari_Reddy
 *
 */
@Transactional
@Service
public class OrderConfirmationServiceImpl implements OrderConfirmationService {
	Log logger=LogFactory.getLog(OrderConfirmationServiceImpl.class);
	@Autowired
	OrderConfirmationDao orderConfirmationDao;
	@Autowired
	CartDao cartdao;
	@Autowired
	UserDao userDao;
	@Autowired
	WalletDao walletDao;
	
	@Autowired
	CartDetailDao cartDetailDao;
	
	@Autowired
	WalletService walletService;
	
	@Autowired
	CartService cartService;

	/**
	 *{@inheritDoc}
	 */
	@Override
	public OrderResponseDto purchaseProduct(OrderRequestDto orderRequestDto, Long userId) {
		
		logger.info("inside oderservice imppl purchase product method");
		
		OrderConfirmation orderconfirmation = new OrderConfirmation();
		
		OrderResponseDto orderResponseDto=new OrderResponseDto();
		
		Optional<User> user = userDao.findByUserId(userId);
		
		if (!user.isPresent()) {
			
			logger.info(ApplicationConstants.LOGINFO_ORDERHISTORY_2);
			
			throw new UserNotFoundException(ApplicationConstants.USER_NOT_FOUND);
		}
		Optional<Cart> cartOptional = cartdao.findByCartId(orderRequestDto.getCartId());
		if (!cartOptional.isPresent()) {
			
			logger.info("validating cartid");
			
			throw new CartNotFoundException("CartId not found");
		}
		Optional<Wallet> walletOPtional = walletDao.findByUserAndWalletNumber(user.get(),
				orderRequestDto.getWalletNumber());
		
		if (!walletOPtional.isPresent()) {
			
			logger.info("validating walletnumber");
			
			throw new WalletNotFoundException("wallent number with this userid is not found");
		}
		Optional<Wallet> walletOPtional1Optional = walletDao.findByWalletIdAndExpiryDate(
				walletOPtional.get().getWalletId(), LocalDate.parse(orderRequestDto.getExpiryDate()));
		

		if (!walletOPtional1Optional.isPresent()) {
			
			logger.info(ApplicationConstants.LOGINFO_ORDERCONFIRMATION_SERVICE_2);
			
			throw new WalletNotFoundException(ApplicationConstants.WALLET_NOT_FOUND);
		}
		if((walletOPtional.get().getBalance()<cartOptional.get().getAmount()))
			
		{
			logger.info(ApplicationConstants.LOGINFO_ORDERCONFIRMATION_SERVICE_1);
			
			throw new BalanceInsufficientException(ApplicationConstants.BALANCE_INSUFFICIENT);
		}
		
		Optional<Cart> carOptionalById = cartdao.findByUserAndCartId(user.get(), orderRequestDto.getCartId());
		if(!carOptionalById.isPresent())
		{
			logger.info(ApplicationConstants.LOGINFO_ORDERCONFIRMATION_SERVICE_3);
			
			throw new CartNotFoundException(ApplicationConstants.CART_NOT_FOUND);
		}
		Optional<OrderConfirmation> orderConfrimationOptional = orderConfirmationDao.findByCart(cartOptional.get());
		
		if(orderConfrimationOptional.isPresent())
			
			throw new CartNotFoundException(ApplicationConstants.CART_NOT_FOUND);
	    
		orderconfirmation.setOrderDate(LocalDate.now());
		orderconfirmation.setUser(user.get());
		orderconfirmation.setCart(cartOptional.get());
		orderConfirmationDao.save(orderconfirmation);
		
		logger.info(ApplicationConstants.UPDATE_BALANCE);
		
		walletService.updatebalance(cartOptional.get().getAmount(),walletOPtional1Optional.get().getWalletId());
		
		logger.info(ApplicationConstants.UPDATE_STATUS);
		
		cartService.updateStatus(orderRequestDto.getCartId());
		
		orderResponseDto.setMessage(" your order placed successfully");
		orderResponseDto.setOrderConfirmationId(orderconfirmation.getOrderConfirmationId());
		orderResponseDto.setStatusCode(200);
		BeanUtils.copyProperties(orderconfirmation, orderResponseDto);
		return orderResponseDto;

	}

	
	@Override
	public OrderHistoryResponseDto getOrderHistory(String orderDate, Long userId) {
		
		logger.info(ApplicationConstants.LOGINFO_ORDERCONFIRMATION_SERVICE_4);
		
		Optional<User> userOptional = userDao.findByUserId(userId); 
		
		if(!userOptional.isPresent())
		{
			logger.info(ApplicationConstants.LOGINFO_ORDERHISTORY_2);
			
			throw new UserNotFoundException(ApplicationConstants.USER_NOT_FOUND);
		}
		
		Optional<List<OrderConfirmation>> orderConfirmationOptional = orderConfirmationDao.findByOrderDateAndUser(LocalDate.parse(orderDate),userOptional.get());
		
		if(!orderConfirmationOptional.isPresent())
		{
			logger.info(ApplicationConstants.LOGINFO_ORDERCONFIRMATION_SERVICE_5);
			
			throw new NoOrdersFoundException(ApplicationConstants.NO_ORDERS_FOUND);
		}
		
		List<Cart> cartList = orderConfirmationOptional.get().stream().map(OrderConfirmation::getCart).collect(Collectors.toList());
		
		List<List<Product>> productList = cartList.stream().map(this::getProductsFromCart).collect(Collectors.toList());
		
		
		List<List<OrderHistoryDto>> orderHistoryDtoList  = 	productList.stream().map(this::getOrderHistoryDto).collect(Collectors.toList());
		
		OrderHistoryResponseDto orderHistoryResponseDto = new OrderHistoryResponseDto();
		
		
		orderHistoryResponseDto.setMessage(ApplicationConstants.ORDERS_FOUND);
		orderHistoryResponseDto.setStatusCode(ApplicationConstants.ORDERS_FOUND_CODE);
		orderHistoryResponseDto.setOrderHistoryDtoList(orderHistoryDtoList);
		
		return orderHistoryResponseDto;
	}

	private List<Product> getProductsFromCart(Cart cart)
	{
		
		Optional<List<CartDetail>> cartDetialList = cartDetailDao.findByCart(cart);
		
		if(!cartDetialList.isPresent())		
		{
			logger.info(ApplicationConstants.LOGINFO_ORDERCONFIRMATION_SERVICE_6);
			throw new CartNotFoundException(ApplicationConstants.CART_NOT_FOUND);
		}
		
		logger.info(cartDetialList.get().stream().map(CartDetail::getProduct).collect(Collectors.toList()).size() +"---size");
		logger.info(cartDetialList.get().stream().map(CartDetail::getProduct).collect(Collectors.toList()).get(0).getProductId());
		
		
		
		return cartDetialList.get().stream().map(CartDetail::getProduct).collect(Collectors.toList());
		
	}
	
	private List<OrderHistoryDto> getOrderHistoryDto(List<Product> productList)
	{
		logger.info(ApplicationConstants.LOGINFO_ORDERCONFIRMATION_SERVICE_7);
		
		List<OrderHistoryDto> orderHistoryList = productList.stream().map(this::getProducts).collect(Collectors.toList());
		
		logger.info(orderHistoryList.size()+ " size of orderHistory");
		return orderHistoryList;
		
	}
	
	private OrderHistoryDto getProducts(Product product)
	{
		logger.info(ApplicationConstants.LOGINFO_ORDERCONFIRMATION_SERVICE_8);
		
		OrderHistoryDto orderHistoryDto = new OrderHistoryDto();
		
		BeanUtils.copyProperties(product, orderHistoryDto);
		
		return orderHistoryDto;
		
	}

}