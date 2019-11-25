package com.example.rabbitmq.sender.rabbit;

import com.example.rabbitmq.sender.SenderComponent;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableRabbit
@EnableScheduling
@SpringBootApplication
public class RabbitSenderApplication {
    
    @Bean
    public Queue hello() {
        return new Queue("hello");
    }
    
    @Bean
    public SenderComponent senderComponent(RabbitTemplate template, Queue queue) {
        return new SenderComponent(new RabbitMessageSender(template, queue));
    }
    
    public static void main(String[] args) {
        SpringApplication.run(RabbitSenderApplication.class, args);
    }

}
