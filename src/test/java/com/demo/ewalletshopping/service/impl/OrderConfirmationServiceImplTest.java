/*package com.demo.ewalletshopping.service.impl;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import com.demo.ewalletshopping.dao.CartDao;
import com.demo.ewalletshopping.dao.OrderConfirmationDao;
import com.demo.ewalletshopping.dao.UserDao;
import com.demo.ewalletshopping.dao.WalletDao;
import com.demo.ewalletshopping.dto.OrderRequestDto;
import com.demo.ewalletshopping.dto.OrderResponseDto;
import com.demo.ewalletshopping.model.Cart;
import com.demo.ewalletshopping.model.OrderConfirmation;
import com.demo.ewalletshopping.model.User;
import com.demo.ewalletshopping.model.Wallet;

@ExtendWith(MockitoExtension.class)
public class OrderConfirmationServiceImplTest {
	@Mock
	OrderConfirmationDao orderConfirmationDao;
	@Mock
	CartDao cartDao;
	@Mock
	UserDao userDao;
	@Mock
	WalletDao walletDao;
	@InjectMocks
	OrderConfirmationServiceImpl orderConfirmationServiceImpl;
	
	User user;
 Wallet wallet;
	Cart cart;
	@BeforeEach
	public void setUp() {
		user = new User();
		cart=new Cart();
		wallet = new Wallet();
	}
	@Test
	public void purchaseAProduct() {
		User user=new User();
        user.setMobileNumber("8106147086");
        user.setPassword("reddy");
        user.setUserId(1L);
        user.setUserName("lahari");
       
        
        OrderRequestDto requestdto=new OrderRequestDto();
        requestdto.setCartId(1L);
        requestdto.setExpiryDate("2020-7-13");
        requestdto.setWalletNumber(5678L);
       
        OrderResponseDto responsedto=new OrderResponseDto();
        responsedto.setMessage("order placed success");
        responsedto.setStatusCode(200);
        
		OrderConfirmation orderconfirmation = new OrderConfirmation();
		orderconfirmation.setCart(cart);
		orderconfirmation.setOrderConfirmationId(1L);
		orderconfirmation.setOrderDate(LocalDate.now());
		orderconfirmation.setUser(user);
		when(userDao.findByUserId(1L)).thenReturn(Optional.of(user));
		when(cartDao.findByCartId(1L)).thenReturn(Optional.of(cart));
		when(walletDao.findByUserAndWalletNumber(user.get(),
                orderRequestDto.getWalletNumber());).thenReturn(Optional.of(wallet));
		OrderConfirmationServiceImpl.purchaseAProduct();
		verify(orderConfirmationDao).f
	}

}*/
