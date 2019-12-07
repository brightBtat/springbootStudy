package com.it.rabbitmqtest.springboot_rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class HelloSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(){
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String context = "hello"+date;
        System.out.println("sneder:"+context);;
        this.rabbitTemplate.convertAndSend("q_hello",context);
    }

    public void send_work(int i){
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String context = "hello "+i+" "+date;
        System.out.println("sender:"+context);
        this.rabbitTemplate.convertAndSend("q_hello",context);
    }
}
