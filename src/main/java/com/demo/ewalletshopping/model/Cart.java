package com.demo.ewalletshopping.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.demo.ewalletshopping.dto.Status;

/**
 * @author Suma
 * Generates table cart with cartId,userId,
 * status and amount
 *
 */
@Entity
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long cartId;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private User user;
	@Enumerated(EnumType.STRING)
	private Status status;
	private double amount;
	
	public Long getCartId() {
		return cartId;
	}
	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	
	
	

}
