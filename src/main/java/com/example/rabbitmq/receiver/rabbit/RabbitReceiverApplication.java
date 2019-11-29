package com.example.rabbitmq.receiver.rabbit;

import com.example.rabbitmq.receiver.ReceiverComponent;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@EnableRabbit
@SpringBootApplication
public class RabbitReceiverApplication {
    
    @Bean
    public Queue hello() {
        return new Queue("hello");
    }
    
    @Bean
    public ReceiverComponent receiverComponent() {
        return new ReceiverComponent();
    }
    
    @Bean
    public RabbitMessageListener rabbitMessageListener() {
        return new RabbitMessageListener(receiverComponent());
    }
    
    public static void main(String[] args) {
        SpringApplication.run(RabbitReceiverApplication.class, args);
    }

}
