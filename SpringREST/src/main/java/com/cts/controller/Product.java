

package com.cts.controller;

import org.springframework.stereotype.Component;

@Component
public class Product {
	
	
	private int prodId;
	private String prodName;
	private int prodQuantity;
	private float prodPrice;
	
	
	public Product() {
		
	}
	

	public Product(int prodId, String prodName, int prodQuantity, float prodPrice) {
	
		this.prodId = prodId;
		this.prodName = prodName;
		this.prodQuantity = prodQuantity;
		this.prodPrice = prodPrice;
	}

	

	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public int getProdQuantity() {
		return prodQuantity;
	}
	public void setProdQuantity(int prodQuantity) {
		this.prodQuantity = prodQuantity;
	}
	public float getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(float prodPrice) {
		this.prodPrice = prodPrice;
	}

	
	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", prodName=" + prodName + ", prodQuantity=" + prodQuantity
				+ ", prodPrice=" + prodPrice + "]";
	}
	
	
	
	

}

