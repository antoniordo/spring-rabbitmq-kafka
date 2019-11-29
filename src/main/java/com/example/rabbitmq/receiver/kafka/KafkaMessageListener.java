package com.example.rabbitmq.receiver.kafka;

import com.example.rabbitmq.receiver.ReceiverComponent;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.transaction.annotation.Transactional;

@KafkaListener(id = "KafkaMessageListener", topics = "hello", groupId = "demo")
public class KafkaMessageListener {
    
    private ReceiverComponent receiverComponent;
    
    public KafkaMessageListener(ReceiverComponent receiverComponent) {
        this.receiverComponent = receiverComponent;
    }
    
    @KafkaHandler
    @Transactional
    public void receive(String in) {
//        if (in.contains("error")) {
//            throw new RuntimeException("erro do consumidor");
//        }
        receiverComponent.receive(in);
    }
    
}
