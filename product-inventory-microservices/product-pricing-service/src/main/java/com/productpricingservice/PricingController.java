package com.productpricingservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PricingController {
	
	@Autowired
	public PricingRepository repo;
	
	@GetMapping("/prices")
	public List<PricingModel> getAllPrices(){
		return repo.findAll();
	}
	
	@GetMapping("/prices/details/{id}")
	public ResponseEntity<PricingModel> getPriceById(@PathVariable Long id){
		PricingModel model=repo.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Price doesn't exist with the specified id: "+id));
		return ResponseEntity.ok(model);
	}

}
