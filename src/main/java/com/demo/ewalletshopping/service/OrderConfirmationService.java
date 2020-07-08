package com.demo.ewalletshopping.service;

import com.demo.ewalletshopping.dto.OrderRequestDto;
import com.demo.ewalletshopping.dto.OrderResponseDto;

/**
 * @author Lahari_Reddy
 *
 */
public interface OrderConfirmationService {
	/**this method is used to save and display message and ststus code
	 * @param orderRequestDto
	 * @param userId
	 * @return message and status cde
	 */
	OrderResponseDto purchaseAProduct(OrderRequestDto orderRequestDto,Long userId);
	
	

}
