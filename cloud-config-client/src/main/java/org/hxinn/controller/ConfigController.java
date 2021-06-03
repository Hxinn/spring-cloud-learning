package org.hxinn.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {
    @Value("${config.info}")
    private String name;

    @GetMapping("config/info")
    public String configInfo(){
        return name;
    }
}
