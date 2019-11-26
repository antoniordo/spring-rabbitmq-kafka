package com.example.rabbitmq.receiver.kafka;

import com.example.rabbitmq.common.KafkaTopics;
import com.example.rabbitmq.receiver.ReceiverComponent;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;

import java.util.UUID;

@EnableKafka
@SpringBootApplication
public class KafkaReceiverApplication {
    
    @Bean
    public NewTopic hello() {
        return KafkaTopics.createHelloNewTopic();
    }
    
    @Bean
    public KafkaMessageListener kafkaMessageHandler() {
        return new KafkaMessageListener(new ReceiverComponent(UUID.randomUUID().toString()));
    }
    
    public static void main(String[] args) {
        SpringApplication.run(KafkaReceiverApplication.class, args);
    }

}
