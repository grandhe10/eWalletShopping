package com.demo.ewalletshopping.service.impl;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.demo.ewalletshopping.constants.ApplicationConstants;
import com.demo.ewalletshopping.dao.ProductDao;
import com.demo.ewalletshopping.dto.ProductResponse;
import com.demo.ewalletshopping.dto.ProductResponseDto;
import com.demo.ewalletshopping.exception.ProductNotFoundException;
import com.demo.ewalletshopping.model.Product;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

	@Mock
	ProductDao productDao;

	@InjectMocks
	ProductServiceImpl productServiceImpl;
	
	ProductResponseDto productResponseDto;
	ProductResponse productResponse;
	
	
	@Test
	public void getListByProductName()
	{
		ProductResponse productResponse = new ProductResponse();
    	
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
    	
    	productResponseList.add(productResponse);
    	
    	Product product = new Product();
    	product.setDescription("description");
    	product.setPrice(200);
    	product.setProductId(1L);
    	product.setProductName("product1");
    	
    	List<Product> productList = new ArrayList<>();
    	productList.add(product);
    	
    	when(productDao.findByProductNameContaining(any(String.class))).thenReturn(Optional.of(productList));
    	productServiceImpl.getProductListByName("product1");
    	verify(productDao).findByProductNameContaining(any(String.class));
	}
	

	@Test
	public void getListByProductName1() throws ProductNotFoundException
	{
		ProductResponse productResponse = new ProductResponse();
    	
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
    	
    	productResponseList.add(productResponse);
    	
    	Product product = new Product();
    	product.setDescription("description");
    	product.setPrice(200);
    	product.setProductId(1L);
    	product.setProductName("product1");
    	
    	List<Product> productList = new ArrayList<>();
    	productList.add(product);
    	

	    ProductNotFoundException exception = assertThrows(ProductNotFoundException.class, () -> {
	        productServiceImpl.getProductListByName("product1");
	    });
	 
	    String expectedMessage = ApplicationConstants.PRODUCT_NOT_FOUND;
	    String actualMessage = exception.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
}
	
	
}