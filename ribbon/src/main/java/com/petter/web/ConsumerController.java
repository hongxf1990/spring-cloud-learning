package com.petter.web;

import com.petter.service.ComputeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author hongxf
 * @since 2017-07-05 16:07
 */
@RestController
public class ConsumerController {

    /*@Resource
    private RestTemplate restTemplate;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        return restTemplate.getForEntity("http://COMPUTE-SERVICE/add?a=10&b=20", String.class).getBody();
    }*/

    @Resource
    private ComputeService computeService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        return computeService.addService2();
    }
}
