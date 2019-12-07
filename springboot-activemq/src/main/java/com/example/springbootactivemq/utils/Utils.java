package com.example.springbootactivemq.utils;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Destination;

@Configuration
public class Utils {

    @Bean
    public Destination getTopic(){
        return new ActiveMQTopic("myTopic");
    }
}
