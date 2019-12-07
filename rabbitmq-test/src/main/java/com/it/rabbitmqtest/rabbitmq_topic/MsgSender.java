package com.it.rabbitmqtest.rabbitmq_topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MsgSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send1(){
        String context = "hi,i am message 1";
        System.out.println("Sender:"+context);
        this.amqpTemplate.convertAndSend("mybootexchange","topic.message",context);
    }

    public void send2(){
        String context = "hi,i am message 2";
        System.out.println("Sender:"+context);
        this.amqpTemplate.convertAndSend("mybootexchange","topic.messages",context);
    }
}
