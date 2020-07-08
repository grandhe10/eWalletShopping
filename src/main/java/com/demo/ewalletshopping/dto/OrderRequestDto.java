package com.demo.ewalletshopping.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class OrderRequestDto {
	@NotNull(message="cartId is mandatory")
	@Min(1)
	private Long cartId;
	@NotNull(message="walletNumber is mandatory")
	private Long walletNumber;
	
	@NotEmpty(message="expiryDate is mandatory")
	
	private String expiryDate;
	
	public Long getCartId() {
		return cartId;
	}
	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}
	public Long getWalletNumber() {
		return walletNumber;
	}
	public void setWalletNumber(Long walletNumber) {
		this.walletNumber = walletNumber;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}


}
