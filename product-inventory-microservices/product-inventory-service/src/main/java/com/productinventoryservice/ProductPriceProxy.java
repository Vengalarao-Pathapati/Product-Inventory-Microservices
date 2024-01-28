package com.productinventoryservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="pricing-service",url="localhost:8200")
@FeignClient(name="pricing-service")
public interface ProductPriceProxy {
	@GetMapping("/prices/details/{id}")
	public InventoryModel retrievePriceDetails(@PathVariable Long id);
	
//	@GetMapping("/prices")
//	public InventoryModel prices();

}
