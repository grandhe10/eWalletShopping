package com.demo.ewalletshopping.exception;

public class NoOrdersFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NoOrdersFoundException(String exception) {
		super(exception);
	}
}