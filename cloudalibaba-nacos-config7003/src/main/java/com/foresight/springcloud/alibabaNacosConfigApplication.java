package com.foresight.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableDiscoveryClient
public class alibabaNacosConfigApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext =SpringApplication.run(alibabaNacosConfigApplication.class, args);
        // String useLocalCache =applicationContext.getEnvironment().getProperty("useLocalCache");
        // System.out.println("****useLocalCache:"+useLocalCache);
	}

}
