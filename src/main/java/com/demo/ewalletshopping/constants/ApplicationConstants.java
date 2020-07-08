package com.demo.ewalletshopping.constants;

import org.springframework.http.HttpStatus;

public class ApplicationConstants {
	
	private ApplicationConstants()
	{
		
	}
	
	public static final Integer INVALD_INPUT = 417;
	public static final String UNAUTHORIZED_USER = "User credentials incorrect!! Please verify";
	public static final Integer UNAUTHORIZED_USER_CODE =HttpStatus.UNAUTHORIZED.value();
	public static final String USER_NOT_FOUND = "Please verify userId";
	public static final Integer USER_NOT_FOUND_CODE = 600;
	public static final int USER_LOGGED_CODE = HttpStatus.FOUND.value();
	public static final String USER_LOGGED_IN = "user logged in successfully";
	public static final Object LOGINFO_USER_1 = "Authenticating user";
	public static final Object LOGINFO_USERCONTROLLER_1 = "UserService method Login User is  found";
	public static final Object LOGINFO_USER_2 = "User found ";
	public static final Object LOGINFO_USER_3 = "User not found";
	public static final Object LOGINFO_ORDERCONTROLLER_1 = "orderHistory Service method placeOrder is found";
	public static final Object LOGINFO_ORDERHISTORY_1 = "Verifying user";
	public static final Object LOGINFO_ORDERHISTORY_2 = "User not found";
	public static final String ORDER_SUCCESS = "Order placed successfully";
	public static final Integer ORDER_SUCCESS_CODE = HttpStatus.ACCEPTED.value();
	public static final Object LOGINFO_ORDERHISTORY_3 = "collecting petIds entered";
	public static final Object LOGINFO_ORDERHISTORY_4 = "petIds are not found";
	public static final Object LOGINFO_ORDERHISTORY_5 = "Order saved successfully";
	public static final Object LOGINFO_USERCONTROLLER_2 = "Entered getOrder history method ";
	public static final String NO_ORDERS_FOUND = "You dont have any previous orders";
	public static final Integer NO_ORDERS_FOUND_CODE = 700;
	public static final Object LOGINFO_USER_4 = "No pet found with the petId";
	public static final Object LOGINFO_USER_5 = "Returning the order history of the user";
	public static final Object LOGINFO_PETCONTROLLER_1 = "Found getPetAnimalsList method";
	public static final String WALLET_NOT_FOUND = "Please verify your wallet credetials";
	public static final Integer WALLET_NOT_FOUND_CODE = 800;
	public static final String CART_NOT_FOUND = "Please verify cartId";
	public static final Integer CART_NOT_FOUND_CODE = 900;
	public static final String BALANCE_INSUFFICIENT = "Please verify your balance";
	public static final Integer BALANCE_INSUFFICIENT_CODE = 901;
	

}
