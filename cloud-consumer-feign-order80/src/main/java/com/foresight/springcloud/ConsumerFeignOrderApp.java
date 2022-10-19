package com.foresight.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ConsumerFeignOrderApp {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeignOrderApp.class, args);
    }

}
