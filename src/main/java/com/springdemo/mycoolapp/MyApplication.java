package com.springdemo.mycoolapp;

import com.springdemo.mycoolapp.rest.Alien;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MyApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context= SpringApplication.run(MyApplication.class, args);
        Alien a =context.getBean(Alien.class);
        a.show();
        System.out.println("Welcome to spring boot");
    }

}
