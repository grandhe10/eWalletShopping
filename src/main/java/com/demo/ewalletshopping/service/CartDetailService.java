package com.demo.ewalletshopping.service;

import com.demo.ewalletshopping.model.Cart;

public interface CartDetailService {

	/**
	 * This method is used to add products to cartDetail
	 * @param productId
	 * @param userId
	 * @return 
	 */
	double addToCart(Long productId, Long userId,Cart cart);

}
