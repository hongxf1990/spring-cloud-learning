package com.petter.component;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * 消息生产者
 * @author hongxf
 * @since 2017-07-13 16:36
 */
@Component
public class Sender {

    @Resource
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String context = "hello " + LocalDateTime.now();
        System.out.println("Sender : " + context);

        rabbitTemplate.convertAndSend("hello", context);
    }

}
