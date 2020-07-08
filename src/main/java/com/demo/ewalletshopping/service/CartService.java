package com.demo.ewalletshopping.service;

import java.util.List;

import javax.validation.Valid;

import com.demo.ewalletshopping.dto.CartResponse;
import com.demo.ewalletshopping.dto.ProductIdDto;

public interface CartService {

	/**
	 * This method is used to add products to cart
	 * @param productIdList
	 * @return CartResponse with parameters message,statusCode,cartId and amount
	 */
	CartResponse addProductsToCart(@Valid List<ProductIdDto> productIdList,Long userId);

	/**
	 * This method is used to update the status of cart
	 * @param cartId
	 */
	void updateStatus(Long cartId);
	
	
	

}
