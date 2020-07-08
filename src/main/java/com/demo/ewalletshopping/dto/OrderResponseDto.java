package com.demo.ewalletshopping.dto;

public class OrderResponseDto {
	
	
	private String message;
	private Integer statusCode;
	private Long orderConfirmationId;
	public Long getOrderConfirmationId() {
		return orderConfirmationId;
	}
	public void setOrderConfirmationId(Long orderConfirmationId) {
		this.orderConfirmationId = orderConfirmationId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

}