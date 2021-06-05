package org.hxinn;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ConfigClientApplication2 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication2.class,args);
    }
}
