package com.petter.web;

import org.apache.log4j.Logger;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author hongxf
 * @since 2017-07-04 17:26
 */
@RestController
public class ComputeController {

    private final Logger logger = Logger.getLogger(ComputeController.class);

    @Resource
    private DiscoveryClient client;

    @RequestMapping(value = "/minus" ,method = RequestMethod.GET)
    public Integer add(
            @RequestParam Integer a,
            @RequestParam Integer b
    ) {
        ServiceInstance instance = client.getLocalServiceInstance();
        Integer r = a - b;
        logger.info("/minus, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
        return r;
    }
}
