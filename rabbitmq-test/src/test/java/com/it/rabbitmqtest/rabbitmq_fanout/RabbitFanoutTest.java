package com.it.rabbitmqtest.rabbitmq_fanout;

import com.it.rabbitmqtest.rabbitmq_topic.MsgSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitFanoutTest {
    @Autowired
    private MsgSenderFanout msgSenderFanout;

    @Test
    public void send() throws Exception{
        msgSenderFanout.send();
    }
}
