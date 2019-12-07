package com.it.rabbitmqtest.springboot_rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class HelloReceiver2 {
    @RabbitListener(queues = "q_hello")
    public void process(String hello){
        System.out.println("receiver2:"+hello);
    }

}
