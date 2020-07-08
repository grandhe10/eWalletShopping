package com.demo.ewalletshopping.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.ewalletshopping.constants.ApplicationConstants;
import com.demo.ewalletshopping.dto.LoginDto;
import com.demo.ewalletshopping.dto.LoginResponseDto;
import com.demo.ewalletshopping.service.UserService;

/**
 * @author Suma
 * This controller is used to send request related to user
 * and get a response based on the request
 *
 */
@RestController
public class UserController {

Log logger = LogFactory.getLog(UserController.class);
	
	@Autowired
	UserService userService;
	/**
	 * This method is used for User Authentication
	 * @param loginDto
	 * @return ResponseEntity with headers and LoginResponseDto with message and statusCode
	 */
	
	@PostMapping("/users")
	public ResponseEntity<LoginResponseDto> loginUser(@Valid @RequestBody LoginDto loginDto)
	{
		logger.info(ApplicationConstants.LOGINFO_USERCONTROLLER_1);
		return new ResponseEntity<>(userService.loginUser(loginDto),HttpStatus.OK);
	}

}
