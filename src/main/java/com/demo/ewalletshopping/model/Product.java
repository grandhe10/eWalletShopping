package com.demo.ewalletshopping.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * @author Suma
 * Generates table product with productId,poductName,
 * price and description
 *
 */
@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long productId;
	private String productName;
	private double price;
	private String description;
	
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
