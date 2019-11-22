package com.example.rabbitmq.receiver;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@EnableRabbit
@SpringBootApplication
public class ReceiverApplication {
    
    @Bean
    public Queue hello() {
        return new Queue("hello");
    }
    
    @Bean
    public ReceiverComponent receiverComponent1() {
        System.out.println("Worker receiverComponent1 initialized.");
        return new ReceiverComponent(1);
    }
    
    @Bean
    public ReceiverComponent receiverComponent2() {
        System.out.println("Worker receiverComponent2 initialized.");
        return new ReceiverComponent(2);
    }

    public static void main(String[] args) {
        SpringApplication.run(ReceiverApplication.class, args);
    }

}
