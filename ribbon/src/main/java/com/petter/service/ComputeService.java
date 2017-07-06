package com.petter.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author hongxf
 * @since 2017-07-06 15:02
 */
@Service
public class ComputeService {

    @Resource
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "addServiceFallback")
    public String addService() {
        return restTemplate.getForEntity("http://COMPUTE-SERVICE/add?a=10&b=20", String.class).getBody();
    }

    public String addServiceFallback() {
        return "error";
    }

    public String addService2() {
        return restTemplate.getForEntity("http://COMPUTE-SERVICE/add?a=10&b=20", String.class).getBody();
    }
}
