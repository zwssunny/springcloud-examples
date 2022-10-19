package com.foresight.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RefreshScope
@Slf4j
public class ConfigController {

    @Value("${useLocalCache:false}")
    private boolean useLocalCache;

    @GetMapping("/config/get")
    public boolean get() {
        log.info("****useLocalCache: "+useLocalCache);
        return useLocalCache;
    }
}
