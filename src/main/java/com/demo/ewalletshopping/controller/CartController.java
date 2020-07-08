package com.demo.ewalletshopping.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.ewalletshopping.constants.ApplicationConstants;
import com.demo.ewalletshopping.dto.CartResponse;
import com.demo.ewalletshopping.dto.ProductIdDto;
import com.demo.ewalletshopping.service.CartService;

@RestController
public class CartController {
	
	Log logger = LogFactory.getLog(ProductController.class);
	
	@Autowired
	CartService cartService;
	
	/**
	 * This method is used to add products to cart
	 * @param productIdList
	 * @return
	 */
	@PostMapping("/users/{userId}/carts")
	public ResponseEntity<CartResponse> addProductsToCart(@Valid @RequestBody List<ProductIdDto> productIdList,@PathVariable("userId") Long userId)
	{
		logger.info(ApplicationConstants.LOGINFO_CARTCONTROLLER_1);
		
		return new ResponseEntity<>(cartService.addProductsToCart(productIdList,userId),HttpStatus.CREATED); 
	}

}
