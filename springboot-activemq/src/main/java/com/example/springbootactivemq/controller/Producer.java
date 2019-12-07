package com.example.springbootactivemq.controller;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;


@RestController
public class Producer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Destination activeMQTopic;

    @RequestMapping("/jms")
    public void send(String text){
        jmsMessagingTemplate.convertAndSend("text",text);
    }

    @RequestMapping("/ps")
    public void send2(String text){
        jmsMessagingTemplate.convertAndSend(activeMQTopic,text);
    }
}
