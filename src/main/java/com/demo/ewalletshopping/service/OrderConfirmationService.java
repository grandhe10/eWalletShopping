package com.demo.ewalletshopping.service;

import com.demo.ewalletshopping.dto.OrderRequestDto;
import com.demo.ewalletshopping.dto.OrderResponseDto;

/**
 * @author Lahari_Reddy
 *
 */
public interface OrderConfirmationService {
	/**this method is used to save and display message and status code
	 * @param orderRequestDto
	 * @param userId
	 * @return message and status with orderConfirmationId
	 */
	OrderResponseDto purchaseAProduct(OrderRequestDto orderRequestDto,Long userId);
	
	

}