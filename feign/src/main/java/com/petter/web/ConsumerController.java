package com.petter.web;

import com.petter.service.ComputeClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author hongxf
 * @since 2017-07-06 13:59
 */
@RestController
public class ConsumerController {

    @Resource
    private ComputeClient computeClient;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add() {
        return computeClient.add(10, 20);
    }
}
