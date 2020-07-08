package com.demo.ewalletshopping.service.impl;

import java.time.LocalDate;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.ewalletshopping.dao.CartDao;
import com.demo.ewalletshopping.dao.OrderConfirmationDao;
import com.demo.ewalletshopping.dao.UserDao;
import com.demo.ewalletshopping.dao.WalletDao;
import com.demo.ewalletshopping.dto.OrderRequestDto;
import com.demo.ewalletshopping.dto.OrderResponseDto;
import com.demo.ewalletshopping.exception.BalanceInsufficientException;
import com.demo.ewalletshopping.exception.CartNotFoundException;
import com.demo.ewalletshopping.exception.UserNotFoundException;
import com.demo.ewalletshopping.exception.WalletNotFoundException;
import com.demo.ewalletshopping.model.Cart;
import com.demo.ewalletshopping.model.OrderConfirmation;
import com.demo.ewalletshopping.model.User;
import com.demo.ewalletshopping.model.Wallet;
import com.demo.ewalletshopping.service.OrderConfirmationService;

/**
 * @author Lahari_Reddy
 *
 */
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

	/**
	 *{@inheritDoc}
	 */
	@Override
	public OrderResponseDto purchaseAProduct(OrderRequestDto orderRequestDto, Long userId) {
		logger.info("inside oderservice imppl purchase apet method");
		OrderConfirmation orderconfirmation = new OrderConfirmation();
		OrderResponseDto orderResponseDto=new OrderResponseDto();
		Optional<User> user = userDao.findByUserId(userId);
		if (!user.isPresent()) {
			logger.info("validating userid");
			throw new UserNotFoundException("User with this user Id is not found ");
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
			logger.info("validating wallet");
			throw new WalletNotFoundException("Wallet is not found");
		}
		if(!(cartOptional.get().getAmount()>=walletOPtional.get().getBalance()))
			
		{
			logger.info("validating balance");
			throw new BalanceInsufficientException("Your balance is insufficient");
		}
	    
		orderconfirmation.setOrderDate(LocalDate.now());
		orderconfirmation.setUser(user.get());
		orderconfirmation.setCart(cartOptional.get());
		orderConfirmationDao.save(orderconfirmation);
		
		orderResponseDto.setMessage(" your order placed successfully");
		orderResponseDto.setOrderConfirmationId(orderconfirmation.getOrderConfirmationId());
		orderResponseDto.setStatusCode(200);
		BeanUtils.copyProperties(orderconfirmation, orderResponseDto);
		return orderResponseDto;
		
		

	}

}
