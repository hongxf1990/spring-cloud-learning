package com.petter;

import com.petter.filter.AccessFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * @author hongxf
 * @since 2017-07-07 14:23
 */
@EnableZuulProxy
@SpringCloudApplication //整合了@SpringBootApplication、@EnableDiscoveryClient、@EnableCircuitBreaker
public class ZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }

    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }
}
