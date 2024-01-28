package com.productinventoryservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class InventoryController {
	
	@Autowired
	public ProductPriceProxy priceproxy;
	
	@Autowired 
	public ProductServiceProxy productproxy;
	
	@Autowired
	public InventoryRepository repo;
	
	@Autowired
	public Environment environment;
	
//	@Autowired
//	public RestTemplate rest;
	
	@GetMapping("/inventories")
	public List<InventoryModel> getAllInventories(){
		return repo.findAll();
	}
//	@GetMapping("/inventories")
//	public InventoryModel allProductsInfo() {
//		InventoryModel products=productproxy.retrieveProducts();
//		InventoryModel prices=priceproxy.prices();
////		InventoryModel inventory=new InventoryModel();
//		List<InventoryModel> inventory=repo.findAll();
//		return new InventoryModel(inventory.get(0),inventory.get(0),products.getProductDesc(),products.getProductName(),prices.getPrice(),products.getEnvironment());
//	}
	
//	@GetMapping("/inventories/details/{id}")
//	public ResponseEntity<InventoryModel> getInventoryById(@PathVariable Long id){
//		
//		InventoryModel model=repo.findById(id)
//				.orElseThrow(()-> new ResourceNotFoundException("inventory doesn't exist with the specified id: "+id));
//		String port=environment.getProperty("local.server.port");
//		model.setEnvironment(port +" Without feign");
//		return ResponseEntity.ok(model);		
//		
//	}
	@GetMapping("/inventories/details/{id}")
	public InventoryModel getInventoryById(@PathVariable Long id) {
		
//		HashMap<Long,Long> uriVariables = new HashMap<>();
//		uriVariables.put(id, id);
		
		ResponseEntity<InventoryModel> responseEntity=new RestTemplate()
				.getForEntity("http://localhost:8000/products/details/"+id, InventoryModel.class);
		InventoryModel inventory=responseEntity.getBody();
		
		ResponseEntity<InventoryModel> priceResponse=new RestTemplate()
				.getForEntity("http://localhost:8200/prices/details/"+id,InventoryModel.class);
		InventoryModel priceInventory=priceResponse.getBody();
		
		InventoryModel inventoryService=repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("not exist"));
		String port=environment.getProperty("local.server.port");
		inventory.setEnvironment(port +" with rest");
		return new InventoryModel(inventory.getId(),inventoryService.getInventoryId(),inventoryService.getInStock()
				,inventory.getProductDesc(),inventory.getProductName(),priceInventory.getPrice(),inventory.getEnvironment());
		}
	
	
	
	@GetMapping("/inventories-feign/details/{id}")
	public InventoryModel allInfo(@PathVariable Long id) {
		InventoryModel products= productproxy.retrieveProductDetails(id);
		
//		InventoryModel price=priceproxy.retrievePriceDetails(id);
		
		InventoryModel inventory=repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("doesnt exist" +id));
		String port=environment.getProperty("local.server.port");
		inventory.setEnvironment(port +" with feign");
		
		return new InventoryModel(inventory.getInventoryId(),products.getId(),inventory.getInStock()
				,products.getProductDesc(),products.getProductName(),inventory.getPrice(),inventory.getEnvironment());
	}

	
	

}
