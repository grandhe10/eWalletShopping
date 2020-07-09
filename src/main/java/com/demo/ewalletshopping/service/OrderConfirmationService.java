package com.demo.ewalletshopping.service;

import com.demo.ewalletshopping.dto.OrderHistoryResponseDto;
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
	 * @return OrderResponseDto with parameters as message,status with orderConfirmationId
	 */
	OrderResponseDto purchaseProduct(OrderRequestDto orderRequestDto,Long userId);

	/**
	 * @author 
	 * This method is used get orderHistory by Date
	 * @param orderDate
	 * @param userId
	 * @return  OrderHistoryDto with parameters as ordersList,message and statusCode
	 */
	OrderHistoryResponseDto getOrderHistory(String orderDate, Long userId);
	
	

}