package org.hxinn.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BiliBiliGatewayConfig {

    @Bean
    public RouteLocator consumerRoutes(RouteLocatorBuilder builder){
        return builder.routes()
                .route("bilibili-douga",r-> r.path("/douga").uri("https://www.bilibili.com/v/douga"))
                .route("bilibili-music",r->r.path("/music").uri("https://www.bilibili.com/v/music"))
                .route("bilibili-dance",r->r.path("/dance").uri("https://www.bilibili.com/v/dance"))
                .build();
    }
}
