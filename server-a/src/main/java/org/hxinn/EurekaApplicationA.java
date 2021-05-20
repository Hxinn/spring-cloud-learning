package org.hxinn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaApplicationA {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplicationA.class,args);
    }
}
