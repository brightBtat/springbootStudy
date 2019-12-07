package com.example.springbootactivemq.controller;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @JmsListener(destination = "text")
    public void receiver(String text){
        System.out.println("接收到的消息："+text);
    }

    @JmsListener(destination = "myTopic")
    public void receiver2(String text){
        System.out.println("发布订阅模式接收消息："+text);
    }
}
