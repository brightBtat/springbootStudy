package com.it.rabbitmqtest.rabbitmq_topic;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver2 {
    @RabbitListener(queues = "q_topic_messages")
    public void process(String hello){
        System.out.println("Receiver2:"+hello);
    }

}
