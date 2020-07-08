package com.demo.ewalletshopping.controller;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.LinkedHashMap;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.demo.ewalletshopping.dto.OrderRequestDto;
import com.demo.ewalletshopping.dto.OrderResponseDto;
import com.demo.ewalletshopping.model.User;
import com.demo.ewalletshopping.service.impl.OrderConfirmationServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class OrderConfirmationControllerTest {
	@Mock
	OrderConfirmationServiceImpl orderimpl;
	MockMvc mockMvc;
	ObjectMapper objectMapper;
	@InjectMocks
	OrderConfirmationController Ordercontroller;
	@Mock
	OrderConfirmationServiceImpl orderserviceimpl;
	OrderResponseDto orderResponseDto;
	OrderRequestDto orderRequestDto;
	@BeforeEach
	public void setUp() {
		objectMapper = new ObjectMapper();
		mockMvc = MockMvcBuilders.standaloneSetup(Ordercontroller).build();

	}
	@Test
	public void buyAnProduct() throws Exception{
		OrderRequestDto requestdto=new OrderRequestDto();
		requestdto.setCartId(1L);
		requestdto.setExpiryDate("2020-7-13");
		requestdto.setWalletNumber(5678L);
		
		OrderResponseDto responsedto=new OrderResponseDto();
		responsedto.setMessage("order placed success");
		responsedto.setOrderConfirmationId(1L);
		responsedto.setStatusCode(200);
		
		User user=new User();
		user.setMobileNumber("8106147086");
		user.setPassword("reddy");
		user.setUserId(1L);
		user.setUserName("lahari");
		
		
	}
	
	
	

}
