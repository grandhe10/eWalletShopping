package com.demo.ewalletshopping.dto;

import java.util.List;

public class OrderHistoryResponseDto {
	
	private String message;
	private Integer statusCode;
	private List<OrderHistoryDto> orderHistoryDtoList;
	
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
	public List<OrderHistoryDto> getOrderHistoryDtoList() {
		return orderHistoryDtoList;
	}
	public void setOrderHistoryDtoList(List<OrderHistoryDto> orderHistoryDtoList) {
		this.orderHistoryDtoList = orderHistoryDtoList;
	}

}
