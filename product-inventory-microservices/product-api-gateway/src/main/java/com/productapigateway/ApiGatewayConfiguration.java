package com.productapigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
	
	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		return builder.routes().route(p -> p.path("/get").filters(f -> f
				.addRequestHeader("MyHeader", "MyURI")
				.addRequestParameter("Param", "MyValue"))
				.uri("http://httpbin.org:80"))
//				.route(p -> p.path("/the path of our application url/**").uri("lb://application name in eureka server")).build();
				.route(p -> p.path("/products/**").uri("lb://product-service"))
				.route(p -> p.path("/inventories/**").uri("lb://inventory-service"))
				.route(p -> p.path("/inventories-feign/**").uri("lb://inventory-service"))
				.route(p -> p.path("/inventories-new/**")
						.filters(f -> f.rewritePath(
								"/inventories-new", "/inventories-feign"))
						.uri("lb://inventory-service"))

				.route(p -> p.path("/prices/**").uri("lb://pricing-service"))



				.build();
	}

}
