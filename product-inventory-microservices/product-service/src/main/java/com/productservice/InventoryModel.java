package com.productservice;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Inventory_service")
public class InventoryModel {

	@Id
	private Long inventoryId;
	private Long id;
	private Boolean inStock;

	public InventoryModel() {
		super();
	}

	public InventoryModel(Long inventoryId, Long id, Boolean inStock) {
		super();
		this.inventoryId = inventoryId;
		this.id = id;
		this.inStock = inStock;
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
