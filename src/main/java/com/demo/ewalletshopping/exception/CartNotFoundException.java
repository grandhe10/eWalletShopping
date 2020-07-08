package com.demo.ewalletshopping.exception;

public class CartNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public CartNotFoundException(String exception) {
		super(exception);
	}
}