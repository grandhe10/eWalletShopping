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
 * Generates table cartDetail with cartDetailId,
 * cartId,productId and addDate
 *
 */
@Entity
public class CartDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long cartDetailId;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Cart cart;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Product product;
	private LocalDate addDate;
	
	public Long getCartDetailId() {
		return cartDetailId;
	}
	public void setCartDetailId(Long cartDetailId) {
		this.cartDetailId = cartDetailId;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public LocalDate getAddDate() {
		return addDate;
	}
	public void setAddDate(LocalDate addDate) {
		this.addDate = addDate;
	}
	

}
