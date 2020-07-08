package com.demo.ewalletshopping.dto;

public class OrderRequestDto {
	
	private Long cartId;
	private Long walletNumber;
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
