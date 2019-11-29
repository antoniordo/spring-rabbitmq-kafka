package com.example.rabbitmq.sender.kafka;

import com.example.rabbitmq.common.KafkaTopics;
import com.example.rabbitmq.sender.SenderComponent;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableKafka
@EnableScheduling
@SpringBootApplication
public class KafkaSenderApplication {
    
    /*@Bean
    public NewTopic hello() {
        return KafkaTopics.createHelloNewTopic();
    }*/
    
    @Bean
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public SenderComponent senderComponent(KafkaTemplate<Object, Object> kafkaTemplate) {
        return new SenderComponent(new KafkaMessageSender(kafkaTemplate));
    }
    
    public static void main(String[] args) {
        SpringApplication.run(KafkaSenderApplication.class, args);
    }

}
