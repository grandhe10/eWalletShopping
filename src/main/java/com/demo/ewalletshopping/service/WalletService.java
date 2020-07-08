package com.demo.ewalletshopping.service;

public interface WalletService {

	/**
	 * This method is used to update the balance of the wallet
	 * @param amount
	 * @param walletId 
	 */
	void updatebalance(double amount, Long walletId);

}
