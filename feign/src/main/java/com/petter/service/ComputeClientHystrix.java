package com.petter.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author hongxf
 * @since 2017-07-06 15:13
 */
@Component
public class ComputeClientHystrix implements ComputeClient {

    @Override
    public Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
        return -9999;
    }
}
