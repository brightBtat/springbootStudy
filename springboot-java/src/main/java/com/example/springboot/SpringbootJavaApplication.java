package com.example.springboot;

import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringbootJavaApplication extends SpringBootServletInitializer implements CommandLineRunner {

    //第一种方式
/*    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(SpringbootJavaApplication.class, args);
        UserService userService = (UserService) context.getBean("userServiceImpl");
        userService.sayHi("tom");
    }*/

    //第二种方式

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        //springboot  启动spring容器
//        SpringApplication.run(SpringbootJavaApplication.class, args);

        //清除springboot的logo
        SpringApplication springApplication = new SpringApplication(SpringbootJavaApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }

    /**
     * 想当于我们纯java程序的main方法
     *
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        userService.sayHi("jerry");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringbootJavaApplication.class);
    }
}
