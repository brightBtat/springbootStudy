package com.it.rabbitmqtest.rabbitmq_fanout;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiverC {
    @RabbitListener(queues = "q_fanout_C")
    public void process(String hello){
        System.out.println("CReceiver:"+hello);
    }
}
