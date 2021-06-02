package org.hxinn;

import org.hxinn.config.BiliBiliGatewayConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableEurekaClient
public class GatewayApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(GatewayApplication.class, args);
        BiliBiliGatewayConfig bean = context.getBean(BiliBiliGatewayConfig.class);
        System.out.println(bean);

    }

}
 