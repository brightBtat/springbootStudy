package com.it.rabbitmqtest.rabbitmq_topic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitTopicTest {
    @Autowired
    private MsgSender msgSender;

    @Test
    public void send1(){
        msgSender.send1();
    }

    @Test
    public void send2(){
        msgSender.send2();
    }
}
