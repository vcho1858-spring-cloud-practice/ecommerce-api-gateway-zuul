package com.example.demo.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

//@Configuration
public class FilterConfig {
//    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes().route(r -> r.path("/user/**").filters(
                        f -> f.addRequestHeader("user-request", "user-request-header")
                                .addResponseHeader("user-response", "user-response-header")).uri("http://user-service/"))
                .route(r -> r.path("/catalog/**").filters(
                                f -> f.addRequestHeader("catalog-request", "catalog-request-header")
                                        .addResponseHeader("catalog-response", "catalog-response-header"))
                        .uri("http://catalog-service/")).build();


    }
}
