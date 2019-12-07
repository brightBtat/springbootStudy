package com.it.rabbitmqtest.rabbitmq_fanout;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiverA {
    @RabbitListener(queues = "q_fanout_A")
    public void process(String hello){
        System.out.println("AReceiver:"+hello);
    }
}
