package com.example.rabbitmq.receiver.rabbit;

import com.example.rabbitmq.receiver.ReceiverComponent;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RabbitListener(queues = "hello")
public class RabbitMessageListener {
    
    private ReceiverComponent receiverComponent;
    
    public RabbitMessageListener(ReceiverComponent receiverComponent) {
        this.receiverComponent = receiverComponent;
    }
    
    @RabbitHandler
    public void receive(String in) {
        receiverComponent.receive(in);
    }
    
}
