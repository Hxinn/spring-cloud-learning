package org.hxinn.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RefreshScope: 刷新配置bean
 */
@RestController
@RefreshScope
public class ConfigController {
    @Value("${config.info}")
    private String name;

    @Value("${server.port}")
    private String port;


    @GetMapping("config/info")
    public String configInfo(){
        return name +" ---- " + port;
    }
}
