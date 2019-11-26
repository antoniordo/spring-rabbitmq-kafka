package com.example.rabbitmq.common;

import org.apache.kafka.clients.admin.NewTopic;

public class KafkaTopics {
    
    private KafkaTopics() {}
    
    public static NewTopic createHelloNewTopic() {
        return new NewTopic("hello", 1, (short) 1);
    }
    
}
