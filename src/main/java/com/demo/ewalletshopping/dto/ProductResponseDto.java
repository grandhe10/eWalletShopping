package com.demo.ewalletshopping.dto;

import java.util.List;

public class ProductResponseDto {
	
	
	private String message;
	private Integer statusCode;
	private List<ProductResponse> productResponseList;
	
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
	public List<ProductResponse> getProductResponseList() {
		return productResponseList;
	}
	public void setProductResponseList(List<ProductResponse> productResponseList) {
		this.productResponseList = productResponseList;
	}
}
