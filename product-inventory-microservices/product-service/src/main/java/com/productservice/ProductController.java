package com.productservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProductController {
	
	@Autowired
	private ProductRepository repository;
	
	@Autowired
	private RestTemplate resttemplate;
	
//	@GetMapping("/products")
//	public List<ProductModel> getAllProducts() {
////		get name and desc from product-service
////		get price from pricing-service
//		
////		get stock avail from inventory-service
//		//return repository.findAll();
//	}
	
	@GetMapping("/products")
	public List<Products> getAllProducts() {
//		get name and desc from product-service
//		get price from pricing-service
		
//		get stock avail from inventory-service
		return repository.findAll();
	}
	
	
	
	 
	
//	@GetMapping("/products/details/{id}")
//	public ProductModel getProductDetaiils(@PathVariable Long id) {
// 		ProductModel model=repository.findById(id)
// 				.orElseThrow(()-> new ResourceNotFoundException("product not exist with id: "+id));
// 		InventoryModel inventory=resttemplate.getForObject("http://localhost:8100/inventories/details/"+id, InventoryModel.class);
// 		PricingModel price=resttemplate.getForObject("http://localhost:8200/prices/details/"+id, PricingModel.class);
// 		
//		return new ProductModel(model.getId(),model.getProductName(),model.getProductDesc(),price.getPrice(),inventory.getInStock());
//	}
	@GetMapping("/products/details/{id}")
	public Products getProductDetaiils(@PathVariable Long id) {
		Products products=repository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("product not exist with id: "+id));
		return products;
	}

}
