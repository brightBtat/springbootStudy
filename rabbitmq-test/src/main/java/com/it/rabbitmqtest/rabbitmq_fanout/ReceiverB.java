package com.it.rabbitmqtest.rabbitmq_fanout;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiverB {
    @RabbitListener(queues = "q_fanout_B")
    public void process(String hello){
        System.out.println("BReceiver:"+hello);
    }
}
