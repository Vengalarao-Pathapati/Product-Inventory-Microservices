package com.productinventoryservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="product-service",url="localhost:8000")
@FeignClient(name="product-service")
public interface ProductServiceProxy {
	@GetMapping("/products/details/{id}")
	public InventoryModel retrieveProductDetails(@PathVariable Long id);
	
//	@GetMapping("/products")
//	public InventoryModel retrieveProducts();

}
