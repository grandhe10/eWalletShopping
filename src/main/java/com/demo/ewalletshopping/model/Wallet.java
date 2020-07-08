package com.demo.ewalletshopping.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author Suma
 * Generates table wallet with walletId,walletNumber,
 * expiryDate ,userId and balance
 *
 */
@Entity
public class Wallet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long walletId;
	private Long walletNumber;
	private LocalDate expiryDate;
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	private User user;
	private double balance;
	
	public Long getWalletId() {
		return walletId;
	}
	public void setWalletId(Long walletId) {
		this.walletId = walletId;
	}
	public Long getWalletNumber() {
		return walletNumber;
	}
	public void setWalletNumber(Long walletNumber) {
		this.walletNumber = walletNumber;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

}
