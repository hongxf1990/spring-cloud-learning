package com.petter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author hongxf
 * @since 2017-07-07 11:13
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ConfigClientBusApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientBusApplication.class, args);
    }
}
