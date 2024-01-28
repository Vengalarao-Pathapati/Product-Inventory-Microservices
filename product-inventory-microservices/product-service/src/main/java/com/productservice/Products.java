package com.productservice;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Products {
	
	@Id
	private Long productId;
	private String productName;
	private String productDesc;
	
	public Products(Long id, String productName, String productDesc) {
		super();
		this.productId = id;
		this.productName = productName;
		this.productDesc = productDesc;
	}
	public Products() {
		super();
	}
	public Long getId() {
		return productId;
	}
	public void setId(Long id) {
		this.productId = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	
	
	

}
