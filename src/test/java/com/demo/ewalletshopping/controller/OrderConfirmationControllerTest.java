package com.demo.ewalletshopping.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

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

import com.demo.ewalletshopping.constants.ApplicationConstants;
import com.demo.ewalletshopping.dto.CartResponse;
import com.demo.ewalletshopping.dto.LoginDto;
import com.demo.ewalletshopping.dto.OrderHistoryDto;
import com.demo.ewalletshopping.dto.OrderHistoryResponseDto;
import com.demo.ewalletshopping.dto.OrderRequestDto;
import com.demo.ewalletshopping.dto.OrderResponseDto;
import com.demo.ewalletshopping.dto.ProductIdDto;
import com.demo.ewalletshopping.dto.Status;
import com.demo.ewalletshopping.model.Cart;
import com.demo.ewalletshopping.model.User;
import com.demo.ewalletshopping.service.CartService;
import com.demo.ewalletshopping.service.OrderConfirmationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@ExtendWith(MockitoExtension.class)
public class OrderConfirmationControllerTest {
	
	
	@Mock
    OrderConfirmationService  orderConfirmationService;

	MockMvc mockMvc;
    ObjectMapper objectMapper;

    @InjectMocks
    OrderConfirmationController orderConfirmationController;
    
    @BeforeEach
    public void setUp() {
        objectMapper = new ObjectMapper();
        mockMvc = MockMvcBuilders.standaloneSetup(orderConfirmationController).build();   
        
    }
	
	@Test
	public void getOrderHistory() throws Exception
	{
		List<OrderHistoryDto> orderHistoryDtoList = new ArrayList<>();
		
		OrderHistoryDto orderHistoryDto = new OrderHistoryDto();
		orderHistoryDto.setPrice(20);
		orderHistoryDto.setProductName("pen");
		orderHistoryDtoList.add(orderHistoryDto);
		
		List<List<OrderHistoryDto>> orderHistoryList = new ArrayList<>();
		orderHistoryList.add(orderHistoryDtoList);
		OrderHistoryResponseDto orderHistoryResponseDto = new OrderHistoryResponseDto();
		
		orderHistoryResponseDto.setMessage(ApplicationConstants.ORDERS_FOUND);
		orderHistoryResponseDto.setStatusCode(ApplicationConstants.ORDERS_FOUND_CODE);
		orderHistoryResponseDto.setOrderHistoryDtoList(orderHistoryList);
		
		
		
		when(orderConfirmationService.getOrderHistory(eq("2020-07-08"),eq(1L))).thenReturn(orderHistoryResponseDto);
		   
		  mockMvc.perform(get("/users/{userId}/orders",1L).
				  contentType(MediaType.APPLICATION_JSON_VALUE)
				  .param("orderDate","2020-07-08")
				  .accept(MediaType.APPLICATION_JSON_VALUE))
		  .andExpect(status().isOk()) 
		  .andExpect(jsonPath("$", Matchers.any(LinkedHashMap.class)));
		  verify(orderConfirmationService).getOrderHistory(eq("2020-07-08"),eq(1L));
}
	
	@Test
	public void purchaseProduct() throws JsonProcessingException, Exception
	{
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
		
		 when(orderConfirmationService.purchaseProduct(any(OrderRequestDto.class),eq(1L))).thenReturn(responsedto);
	        mockMvc.perform(post("/users/{userId}/orders",1L).contentType(MediaType.APPLICATION_JSON_VALUE)
	                .content(objectMapper.writeValueAsString(requestdto)))
	                .andExpect(status().isOk())
	                .andExpect(jsonPath("$", Matchers.any(LinkedHashMap.class)));

	        verify(orderConfirmationService).purchaseProduct(any(OrderRequestDto.class),eq(1L));
	}
	
}