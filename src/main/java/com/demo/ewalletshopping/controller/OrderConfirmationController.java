package com.demo.ewalletshopping.controller;

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
	 * @return message with status code
	 */
	@PostMapping("/users/{userId}/orders")
	public  ResponseEntity<OrderResponseDto> buyAnPet(@Valid @RequestBody OrderRequestDto orderRequestDto,@PathVariable("userId") Long userId)
	{
		Log logger=LogFactory.getLog(OrderConfirmationController.class);
		logger.info("inside buy an pet controller");
		return new ResponseEntity<>(orderConfirmationService.purchaseAProduct(orderRequestDto, userId), HttpStatus.OK);
	}

}
