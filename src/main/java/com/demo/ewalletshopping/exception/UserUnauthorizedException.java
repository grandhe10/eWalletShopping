package com.demo.ewalletshopping.exception;

public class UserUnauthorizedException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public UserUnauthorizedException(String exception) {
		super(exception);
	}
}
