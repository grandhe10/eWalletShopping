package com.demo.ewalletshopping.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import com.demo.ewalletshopping.dto.ProductIdDto;
import com.demo.ewalletshopping.dto.Status;
import com.demo.ewalletshopping.model.Cart;
import com.demo.ewalletshopping.model.User;
import com.demo.ewalletshopping.service.CartService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class CartControllerTest {
	
	@Mock
    CartService cartService;

	MockMvc mockMvc;
    ObjectMapper objectMapper;

    @InjectMocks
    CartController cartController;
    
    @BeforeEach
    public void setUp() {
        objectMapper = new ObjectMapper();
        mockMvc = MockMvcBuilders.standaloneSetup(cartController).build();   
        
    }
    
    @SuppressWarnings("unchecked")
	@Test
    public void addToCart() throws JsonProcessingException, Exception
    {
    	User user = new User();
		user.setPassword("test123");
		user.setUserId(1L);
		user.setUserName("TEST123");	
		
    	Cart cart = new Cart();
    	cart.setAmount(2000);
    	cart.setCartId(1L);
    	cart.setStatus(Status.INCART);
    	cart.setUser(user);
    	
    	CartResponse cartResponse = new CartResponse();
    	cartResponse.setAmount(5000);
    	cartResponse.setCarId(1L);
    	cartResponse.setMessage(ApplicationConstants.CART_SUCCESS);
    	cartResponse.setStatuscode(ApplicationConstants.CART_SUCCESS_CODE);
    	
    	ProductIdDto productIdDto = new ProductIdDto();
    	productIdDto.setProductId(1L);
    	
    	List<ProductIdDto> productList = new ArrayList<>();
    	productList.add(productIdDto);
    	
    	when(cartService.addProductsToCart(any(List.class),eq(1L))).thenReturn(cartResponse);
        mockMvc.perform(post("/users/{userId}/carts",1L).contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(productList)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$", Matchers.any(LinkedHashMap.class)));

        verify(cartService).addProductsToCart(any(List.class),eq(1L));
    }

	
}
