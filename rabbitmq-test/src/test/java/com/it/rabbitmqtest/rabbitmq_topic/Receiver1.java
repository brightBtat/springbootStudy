package com.it.rabbitmqtest.rabbitmq_topic;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver1 {
    @RabbitListener(queues = "q_topic_message")
    public void process(String hello){
        System.out.println("Receiver1:"+hello);
    }

}
