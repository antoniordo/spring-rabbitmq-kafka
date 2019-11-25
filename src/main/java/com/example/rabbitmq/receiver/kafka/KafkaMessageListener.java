package com.example.rabbitmq.receiver.kafka;

import com.example.rabbitmq.receiver.ReceiverComponent;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;

@KafkaListener(id = "KafkaMessageListener", topics = "hello")
public class KafkaMessageListener {
    
    private ReceiverComponent receiverComponent;
    
    public KafkaMessageListener(ReceiverComponent receiverComponent) {
        this.receiverComponent = receiverComponent;
    }
    
    @KafkaHandler
    public void receive(String in) {
        receiverComponent.receive(in);
    }
    
}
