package com.productservice;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class ProductModel {

	@Id
	private Long id;
	private String productName;
	private String productDesc;
	@Transient
	private Integer price;
	@Transient
	private Boolean in_stock;
	 

	public ProductModel() {
		super();
	}

	public ProductModel(Long id, String productName, String productDesc,Integer price,Boolean in_stock) {
		super();
		this.id = id;
		this.productName = productName;
		this.productDesc = productDesc;
		this.price=price;
		this.in_stock=in_stock;
		
		 
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Boolean getIn_stock() {
		return in_stock;
	}

	public void setIn_stock(Boolean in_stock) {
		this.in_stock = in_stock;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
