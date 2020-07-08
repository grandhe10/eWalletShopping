package com.demo.ewalletshopping.service;

import com.demo.ewalletshopping.dto.HistoryRequestDto;
import com.demo.ewalletshopping.dto.OrderHistoryResponseDto;
/**
* @author haritha
*/
public interface OrderConfirmationService {
	
	
	/**
	 * this method used to get order history
	 * @param historyRequestDto
	 * @param userId
	 * @return OrderHistoryResponseDto
	 */
	OrderHistoryResponseDto getOrderHistory(HistoryRequestDto historyRequestDto, Long userId);
}
