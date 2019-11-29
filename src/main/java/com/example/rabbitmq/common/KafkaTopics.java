package com.example.rabbitmq.common;

import org.apache.kafka.clients.admin.NewTopic;

public class KafkaTopics {
    
    private static final String HELLO_TOPIC = "hello";
    private static final int HELLO_PARTITIONS = 2;
    private static final short HELLO_REPLICATION_FACTOR = 3;
    
    private KafkaTopics() {}
    
    public static NewTopic createHelloNewTopic() {
        return new NewTopic(HELLO_TOPIC, HELLO_PARTITIONS, HELLO_REPLICATION_FACTOR);
    }
    
}
