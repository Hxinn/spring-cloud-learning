package org.hxinn.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenFeignLogConfig {

    @Bean
    Logger.Level feignLoggerLeave() {
        return Logger.Level.FULL;
    }
}