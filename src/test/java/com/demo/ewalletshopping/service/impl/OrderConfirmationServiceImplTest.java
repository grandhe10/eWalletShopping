package com.demo.ewalletshopping.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import com.demo.ewalletshopping.dao.CartDao;
import com.demo.ewalletshopping.dao.OrderConfirmationDao;
import com.demo.ewalletshopping.dao.UserDao;
import com.demo.ewalletshopping.dao.WalletDao;
import com.demo.ewalletshopping.dto.OrderRequestDto;
import com.demo.ewalletshopping.dto.OrderResponseDto;
import com.demo.ewalletshopping.model.User;

@ExtendWith(MockitoExtension.class)
public class OrderConfirmationServiceImplTest {
	@Mock
	OrderConfirmationDao orderconfirmationDao;
	@InjectMocks
	OrderConfirmationServiceImpl orderserviceImpl;
	@Mock
	CartDao cartdao;
	@Mock
	UserDao userDao;
	@Mock
	WalletDao walletDao;
	@BeforeEach
	public void setUp() {

	}
	@Test
	public void buyAnPet() throws Exception{
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
		responsedto.setOrderConfirmationId(1L);
		responsedto.setStatusCode(200);
		
		
		
	}
	

}
