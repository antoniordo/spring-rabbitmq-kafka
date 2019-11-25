package com.example.rabbitmq.receiver.rabbit;

import com.example.rabbitmq.receiver.ReceiverComponent;
import com.example.rabbitmq.receiver.kafka.KafkaMessageListener;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@EnableRabbit
@SpringBootApplication
public class RabbitReceiverApplication {
    
    @Bean
    public NewTopic hello() {
        return new NewTopic("hello", 1, (short) 1);
    }
    
    @Bean
    public KafkaMessageListener kafkaMessageHandler() {
        return new KafkaMessageListener(new ReceiverComponent(UUID.randomUUID().toString()));
    }

    public static void main(String[] args) {
        SpringApplication.run(RabbitReceiverApplication.class, args);
    }

}
