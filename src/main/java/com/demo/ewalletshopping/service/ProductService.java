package com.demo.ewalletshopping.service;

import com.demo.ewalletshopping.dto.ProductResponseDto;

public interface ProductService {

	
	/**
	 * This method is used to get the list of products
	 * @param productName
	 * @return ProductResponseDto with message,statusCode and ProductList
	 */
	ProductResponseDto getProductListByName(String productName);

}
