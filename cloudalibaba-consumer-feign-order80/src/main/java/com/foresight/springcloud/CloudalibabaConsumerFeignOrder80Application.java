package com.foresight.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CloudalibabaConsumerFeignOrder80Application {

	public static void main(String[] args) {
		SpringApplication.run(CloudalibabaConsumerFeignOrder80Application.class, args);
	}

}
