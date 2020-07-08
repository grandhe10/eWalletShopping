package com.demo.ewalletshopping.service.impl;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import com.demo.ewalletshopping.constants.ApplicationConstants;
import com.demo.ewalletshopping.dao.UserDao;
import com.demo.ewalletshopping.dto.LoginDto;
import com.demo.ewalletshopping.dto.LoginResponseDto;
import com.demo.ewalletshopping.exception.UserUnauthorizedException;
import com.demo.ewalletshopping.model.User;
@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

	@Mock
	UserDao userDao;

	@InjectMocks
	UserServiceImpl userServiceImpl;
	
	LoginResponseDto loginResponseDto;
	

	@BeforeEach
	public void setUp() {

	}
		
	@Test
	public void loginUserTest() {
		LoginDto loginDto = new LoginDto();
		loginDto.setUserName("TEST123");
		loginDto.setPassword("test123");

		loginResponseDto = new LoginResponseDto();
		loginResponseDto.setMessage("user logged in successfully");
		loginResponseDto.setStatusCode(HttpStatus.FOUND.value());
		loginResponseDto.setUserId(1L);
		User user = new User();
		user.setPassword("test123");
		user.setUserId(1L);
		user.setUserName("TEST123");	
	
		when(userDao.findByUserNameAndPassword(any(String.class),any(String.class))).thenReturn(Optional.of(user));
		userServiceImpl.loginUser(loginDto);
		verify(userDao).findByUserNameAndPassword("TEST123", "test123");

	}
	
	@Test
	public void loginUserTest1() throws UserUnauthorizedException{
		
		LoginDto loginDto = new LoginDto();
		loginDto.setUserName("TEST123");
		loginDto.setPassword("test123");

		loginResponseDto = new LoginResponseDto();
		loginResponseDto.setMessage(ApplicationConstants.USER_LOGGED_IN);
		loginResponseDto.setStatusCode(ApplicationConstants.USER_LOGGED_CODE);
		loginResponseDto.setUserId(1L);
		User user = new User();
		user.setPassword("test123");
		user.setUserId(1L);
		user.setUserName("TEST123");	
		
		
	    UserUnauthorizedException exception = assertThrows(UserUnauthorizedException.class, () -> {
	        userServiceImpl.loginUser(loginDto);
	    });
	 
	    String expectedMessage = ApplicationConstants.UNAUTHORIZED_USER;
	    String actualMessage = exception.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));

	}
	
}