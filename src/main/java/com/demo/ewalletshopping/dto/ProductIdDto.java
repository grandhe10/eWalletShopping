package com.demo.ewalletshopping.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class ProductIdDto {
	
	@NotEmpty(message="please verify your productId")
	@Min(1)
	private long productId;

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

}
