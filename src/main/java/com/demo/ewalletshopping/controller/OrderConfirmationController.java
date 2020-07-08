package com.demo.ewalletshopping.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.ewalletshopping.dto.HistoryRequestDto;
import com.demo.ewalletshopping.dto.OrderHistoryResponseDto;
import com.demo.ewalletshopping.service.OrderConfirmationService;

/**
 * @author haritha
 * This controller is used to get
 *orderHistory
 */
@RestController
public class OrderConfirmationController {
	static Log logger = LogFactory.getLog(OrderConfirmationController.class);
	@Autowired
	OrderConfirmationService orderConfirmationService;
	/**
	 * This method is used to get order history 
	 * @param historyRequestDto
	 * @param userId
	 * @return OrderHistoryResponseDto with parameters message and statusCode
	 */
	
	@GetMapping("/users/{userId}/orders")
	public ResponseEntity<OrderHistoryResponseDto> orderHistory(@RequestBody HistoryRequestDto historyRequestDto,
			@PathVariable("userId") Long userId) {
		
		return new ResponseEntity<>(orderConfirmationService.getOrderHistory(historyRequestDto, userId), HttpStatus.OK);
	}
}
