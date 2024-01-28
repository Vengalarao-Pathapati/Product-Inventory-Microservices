package com.productinventoryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class ProductInventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductInventoryServiceApplication.class, args);
	}
	
//	@Bean
//	public RestTemplate resttemplate() {
//		return new RestTemplate();
//	}

}
