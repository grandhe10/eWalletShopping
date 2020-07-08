package com.demo.ewalletshopping.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.demo.ewalletshopping.service.OrderConfirmationService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class OrderConfirmationControllerTest {
	@Mock
	OrderConfirmationService orderConfirmationService;
	MockMvc mockMvc;
	ObjectMapper objectMapper;
	@InjectMocks
	OrderConfirmationController orderConfirmationController;

	@BeforeEach
	public void setUp() {
		objectMapper = new ObjectMapper();
		mockMvc = MockMvcBuilders.standaloneSetup(orderConfirmationController).build();

	}@Test
	public void orderHistory() throws Exception

	{
		
		
	}
	
}
