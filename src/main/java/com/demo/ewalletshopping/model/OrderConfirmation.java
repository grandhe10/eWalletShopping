package com.demo.ewalletshopping.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author Suma
 * Generates table OrderConfirmation with orderConfirmationId,
 * cartId and orderDate
 *
 */
@Entity
public class OrderConfirmation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long orderConfirmationId;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Cart cart;
	private LocalDate orderDate;
	
	public Long getOrderConfirmationId() {
		return orderConfirmationId;
	}
	public void setOrderConfirmationId(Long orderConfirmationId) {
		this.orderConfirmationId = orderConfirmationId;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	

}
