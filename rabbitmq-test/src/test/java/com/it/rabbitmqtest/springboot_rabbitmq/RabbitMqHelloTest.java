package com.it.rabbitmqtest.springboot_rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqHelloTest {
    @Autowired
    private HelloSender helloSender;

    /**
     * 简单队列模式测试
     * @throws Exception
     */
    @Test
    public void hello() throws Exception{
        helloSender.send();
    }

    /**
     * work队列模式测试
     * @throws Exception
     */
    @Test
    public void oneToMany() throws Exception{
        for (int i = 0; i < 100; i++) {
            helloSender.send_work(i);
            Thread.sleep(300);
        }
    }
}
