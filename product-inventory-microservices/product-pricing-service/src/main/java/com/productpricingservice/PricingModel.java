package com.productpricingservice;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pricing_service")
public class PricingModel {
	
	@Id
	private Long pricingId;
	private Long id;
	private Integer price;
	
	
	public PricingModel() {
		super();
	}


	public PricingModel(Long pricingId, Long id, Integer price) {
		super();
		this.pricingId = pricingId;
		this.id = id;
		this.price = price;
	}


	public Long getPricingId() {
		return pricingId;
	}


	public void setPricingId(Long pricingId) {
		this.pricingId = pricingId;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Integer getPrice() {
		return price;
	}


	public void setPrice(Integer price) {
		this.price = price;
	}
	
	
	
	

}
