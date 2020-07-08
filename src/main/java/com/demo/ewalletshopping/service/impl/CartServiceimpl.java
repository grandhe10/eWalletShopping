package com.demo.ewalletshopping.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.ewalletshopping.constants.ApplicationConstants;
import com.demo.ewalletshopping.dao.CartDao;
import com.demo.ewalletshopping.dao.ProductDao;
import com.demo.ewalletshopping.dao.UserDao;
import com.demo.ewalletshopping.dto.CartResponse;
import com.demo.ewalletshopping.dto.ProductIdDto;
import com.demo.ewalletshopping.dto.Status;
import com.demo.ewalletshopping.exception.CartNotFoundException;
import com.demo.ewalletshopping.exception.ProductNotFoundException;
import com.demo.ewalletshopping.exception.UserNotFoundException;
import com.demo.ewalletshopping.model.Cart;
import com.demo.ewalletshopping.model.Product;
import com.demo.ewalletshopping.model.User;
import com.demo.ewalletshopping.service.CartDetailService;
import com.demo.ewalletshopping.service.CartService;
@Service
public class CartServiceimpl implements CartService{
	
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	CartDetailService cartDetailService;
	
	@Autowired
	CartDao cartDao;

	Log logger = LogFactory.getLog(CartServiceimpl.class);
	
	@Override
	public CartResponse addProductsToCart(List<ProductIdDto> productIdList,Long userId) {
		
		logger.info(ApplicationConstants.LOGINFO_ORDERHISTORY_1);
		
		Optional<User> userOptional = userDao.findByUserId(userId); 
		
		if(!userOptional.isPresent())
		{
			logger.info(ApplicationConstants.LOGINFO_ORDERHISTORY_2);
			
			throw new UserNotFoundException(ApplicationConstants.USER_NOT_FOUND);
		}
		
		logger.info(ApplicationConstants.LOGINFO_ORDERHISTORY_3);
		
		List<Long> productList = productIdList.stream()
				.map(this::validateProductId).collect(Collectors.toList());
		
		if(productList.contains(null))
		{
			logger.info(ApplicationConstants.LOGINFO_ORDERHISTORY_4);
			
			throw new ProductNotFoundException(ApplicationConstants.PRODUCT_NOT_FOUND);
		}
			
		Cart cart = new Cart();
		cart.setStatus(Status.INCART);
		cart.setUser(userOptional.get());
		cartDao.save(cart);
		
		
		logger.info(ApplicationConstants.LOGINFO_ORDERHISTORY_6);
		
		List<Double> orderList = productList.stream().map(petId->saveOrder(petId,userId,cart)).collect(Collectors.toList());
		
		
		double amount = orderList.stream().mapToDouble(a->a).sum();
		
		Optional<Cart> cartOptional = cartDao.findByCartId(cart.getCartId());
		
		if(!cartOptional.isPresent())
			throw new CartNotFoundException(ApplicationConstants.CART_NOT_FOUND);
		
		cartOptional.get().setAmount(amount);
		cartDao.save(cartOptional.get());
		
		CartResponse cartResponse = new CartResponse();
		
		cartResponse.setAmount(cart.getAmount());
		cartResponse.setCarId(cart.getCartId());
		cartResponse.setMessage(ApplicationConstants.CART_SUCCESS);
		cartResponse.setStatuscode(ApplicationConstants.CART_SUCCESS_CODE);
		
		return cartResponse;
		
}
	
	private Long validateProductId(ProductIdDto productDto)
	{
		Optional<Product> productOptional = productDao.findByProductId(productDto.getProductId());
		if(!productOptional.isPresent())
			{
				return null;
			}
		else
			return productOptional.get().getProductId();
		
	}
	
	
	private double saveOrder(Long productId,Long userId,Cart cart)
	{
		
		double price = cartDetailService.addToCart(productId,userId,cart);
		
		return price ;
		
	}
	
}
