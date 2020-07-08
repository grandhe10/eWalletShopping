package com.demo.ewalletshopping.controller;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
import com.demo.ewalletshopping.dto.ProductResponse;
import com.demo.ewalletshopping.dto.ProductResponseDto;
import com.demo.ewalletshopping.model.Product;
import com.demo.ewalletshopping.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {
	
	@Mock
    ProductService productService;

	MockMvc mockMvc;
    ObjectMapper objectMapper;

    @InjectMocks
    ProductController productController;
    
    @BeforeEach
    public void setUp() {
        objectMapper = new ObjectMapper();
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();   
        
    }
 
    @Test
    public void getProductsList() throws Exception
    {
    	ProductResponse productResponse = new ProductResponse();
    	
    	Product product = new Product();
    	product.setDescription("description");
    	product.setPrice(200);
    	product.setProductId(1L);
    	product.setProductName("product1");
		
    	productResponse.setDescritpion("description");
    	productResponse.setPrice(200);
    	productResponse.setProductId(1L);
    	productResponse.setProductName("product1");
    	
    	ProductResponseDto productResponseDto = new ProductResponseDto();
    	
    	List<ProductResponse> productResponseList = new ArrayList<>();
    	
    	productResponseList.add(productResponse);
    	
    	productResponseDto.setStatusCode(ApplicationConstants.PRODUCT_FOUND_CODE);
		productResponseDto.setMessage(ApplicationConstants.PRODUCT_FOUND);
		productResponseDto.setProductResponseList(productResponseList);
    	
		
    	
    	when(productService.getProductListByName(eq("product1"))).thenReturn(productResponseDto);
   
		  mockMvc.perform(get("/products").
				  contentType(MediaType.APPLICATION_JSON_VALUE)
				  .param("productName","product1")
				  .accept(MediaType.APPLICATION_JSON_VALUE))
		  .andExpect(status().isOk()) 
		  .andExpect(jsonPath("$", Matchers.any(LinkedHashMap.class)));
		  verify(productService).getProductListByName(eq("product1"));
    	
    	
    }
    
}