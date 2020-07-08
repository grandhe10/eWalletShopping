package com.demo.ewalletshopping.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.ewalletshopping.dao.CartDao;
import com.demo.ewalletshopping.dao.OrderConfirmationDao;
import com.demo.ewalletshopping.dao.UserDao;
import com.demo.ewalletshopping.exception.CartNotFoundException;
import com.demo.ewalletshopping.exception.UserNotFoundException;
import com.demo.ewalletshopping.model.Cart;
import com.demo.ewalletshopping.model.OrderConfirmation;
import com.demo.ewalletshopping.model.User;
import com.demo.ewalletshopping.service.CartService;
@Service
public class CartServiceimpl implements CartService{
@Autowired
CartDao cartDao;
@Autowired
UserDao userDao;
@Autowired
OrderConfirmationDao orderconfirmationDao;
	@Override
	public boolean UpdateCartStatusByCartIdAndUser(Long cartId, User user) {
		Optional<User> user1 = userDao.findByUserId(user.getUserId());
		
		Optional<Cart> cartOptional = cartDao.findByCartId(cartId);
		
		Optional<Cart> cart=cartDao.findByCartIdAndUser(cartId, user);
		return false;
		
		
		
	}

}
