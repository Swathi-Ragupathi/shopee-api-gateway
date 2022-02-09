package com.learn.microservices.shopeeapigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfig {

	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p->p.path("/shopee-order-service/**").uri("lb://shopee-order-service"))
				.route(p->p.path("/shopee-users-service/**").uri("lb://shopee-users-service"))
				.route(p->p.path("/shopee-product-service/**").uri("lb://shopee-product-service"))
				.build();
	}
}
