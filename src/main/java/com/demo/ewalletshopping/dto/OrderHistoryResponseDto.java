package com.demo.ewalletshopping.dto;

import java.util.List;

public class OrderHistoryResponseDto {
	
	private String message;
	private Integer statusCode;
	private List<List<OrderHistoryDto>> orderHistoryDtoList;
	
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
	public List<List<OrderHistoryDto>> getOrderHistoryDtoList() {
		return orderHistoryDtoList;
	}
	public void setOrderHistoryDtoList(List<List<OrderHistoryDto>> orderHistoryDtoList) {
		this.orderHistoryDtoList = orderHistoryDtoList;
	}
	

}
