package com.demo.ewalletshopping.service.impl;

import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.ewalletshopping.constants.ApplicationConstants;
import com.demo.ewalletshopping.dao.UserDao;
import com.demo.ewalletshopping.dto.LoginDto;
import com.demo.ewalletshopping.dto.LoginResponseDto;
import com.demo.ewalletshopping.exception.UserUnauthorizedException;
import com.demo.ewalletshopping.model.User;
import com.demo.ewalletshopping.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	
Log logger = LogFactory.getLog(UserServiceImpl.class);
	
	
	@Autowired
	UserDao userDao;
	
	@Override
	public LoginResponseDto loginUser(LoginDto loginDto) {
		
		logger.info(ApplicationConstants.LOGINFO_USER_1);
		
		Optional<User> userOptional = userDao.findByUserNameAndPassword(loginDto.getUserName(),loginDto.getPassword());
		
		if(!userOptional.isPresent())
		{
			logger.info(ApplicationConstants.LOGINFO_USER_3);
			
			throw new UserUnauthorizedException(ApplicationConstants.UNAUTHORIZED_USER);
		}
		
		logger.info(ApplicationConstants.LOGINFO_USER_2);
		
		LoginResponseDto loginResponseDto = new LoginResponseDto();
		
		loginResponseDto.setMessage(ApplicationConstants.USER_LOGGED_IN);
		loginResponseDto.setStatusCode(ApplicationConstants.USER_LOGGED_CODE);
		loginResponseDto.setUserId(userOptional.get().getUserId());
		return loginResponseDto;
	}


}
