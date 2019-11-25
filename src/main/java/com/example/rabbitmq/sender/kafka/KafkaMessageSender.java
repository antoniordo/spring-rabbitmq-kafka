package com.example.rabbitmq.sender.kafka;

import com.example.rabbitmq.sender.MessageSender;
import org.springframework.kafka.core.KafkaTemplate;

public class KafkaMessageSender implements MessageSender {
    
    private KafkaTemplate<Object, Object> kafkaTemplate;
    
    public KafkaMessageSender(KafkaTemplate<Object, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    
    @Override
    public void send(String message) {
        kafkaTemplate.send("hello", message);
    }
    
}
