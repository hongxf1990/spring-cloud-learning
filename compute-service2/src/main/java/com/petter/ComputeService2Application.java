package com.petter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ComputeService2Application {

	public static void main(String[] args) {
		SpringApplication.run(ComputeService2Application.class, args);
	}
}
