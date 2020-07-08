package com.demo.ewalletshopping.service;

import com.demo.ewalletshopping.dto.LoginDto;
import com.demo.ewalletshopping.dto.LoginResponseDto;

public interface UserService {

	/**
	 * This method is used for userLogin
	 * @param loginDto
	 * @return LoginResponseDto with parameters as message and statusCode
	 */
	public LoginResponseDto loginUser(LoginDto loginDto);
}
