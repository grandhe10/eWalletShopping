package com.demo.ewalletshopping.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.ewalletshopping.constants.ApplicationConstants;
import com.demo.ewalletshopping.dto.OrderHistoryResponseDto;
import com.demo.ewalletshopping.dto.OrderRequestDto;
import com.demo.ewalletshopping.dto.OrderResponseDto;
import com.demo.ewalletshopping.service.OrderConfirmationService;

/**
 * @author Lahari_Reddy
 *
 */
@RestController
public class OrderConfirmationController {
	Log logger=LogFactory.getLog(OrderConfirmationController.class);
	@Autowired
	OrderConfirmationService orderConfirmationService;
	/**This method is used to buy an pet
	 * @param orderRequestDto
	 * @param userId
	 * @return ResponseEntity with header OK and OrderResponseDto
	 */
	@PostMapping("/users/{userId}/orders")
	public  ResponseEntity<OrderResponseDto> purchaseProduct(@Valid @RequestBody OrderRequestDto orderRequestDto,@PathVariable("userId") Long userId)
	{
		
		logger.info(ApplicationConstants.LOGINFO_ORDERCONFIRMATION_CONTROLLER_1);
		return new ResponseEntity<>(orderConfirmationService.purchaseProduct(orderRequestDto, userId), HttpStatus.OK);
	}

	/**
	 * This method is used to get list of orders of the user by date 
	 * @param orderDate
	 * @param userId
	 * @return ResponseEntity with header OK and OrderHistoryResponseDto
	 */
	@GetMapping("/users/{userId}/orders")
	public ResponseEntity<OrderHistoryResponseDto> getOrderHistory(@RequestParam("orderDate") String orderDate,@PathVariable("userId")Long userId)
	{
		logger.info(ApplicationConstants.LOGINFO_ORDERCONFIRMATION_CONTROLLER_2);
		return new ResponseEntity<>(orderConfirmationService.getOrderHistory(orderDate,userId),HttpStatus.OK);
	}
	
}
