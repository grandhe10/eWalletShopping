package com.demo.ewalletshopping.exception;

public class ProductNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ProductNotFoundException(String exception) {
		super(exception);
	}
}