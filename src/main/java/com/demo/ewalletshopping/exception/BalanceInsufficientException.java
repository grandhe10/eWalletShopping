package com.demo.ewalletshopping.exception;

public class BalanceInsufficientException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public BalanceInsufficientException(String exception) {
		super(exception);
	}
}