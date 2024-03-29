package com.productinventoryservice;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Inventory_service")
public class InventoryModel {

	
	private Long inventoryId;
	@Id
	private Long id;
	private Boolean inStock;
//	JPA's @Transient annotation is used to indicate that a field is not to be persisted(to store permanently) in the database,
	@Transient
	private String productName;
	@Transient
	private String productDesc;
	@Transient
	private Integer price;
	@Transient
	private String environment;


	public InventoryModel() {
		super();
	}

	public InventoryModel(Long inventoryId,Long id, Boolean inStock,String productName,String productDesc, Integer price, String environment ) {
		super();
		this.inventoryId = inventoryId;
		this.id = id;
		this.inStock = inStock;
		this.productName=productName;
		this.productDesc=productDesc;
		this.price=price;
		this.environment=environment;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
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

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Long getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getInStock() {
		return inStock;
	}

	public void setInStock(Boolean inStock) {
		this.inStock = inStock;
	}
	
	

}
