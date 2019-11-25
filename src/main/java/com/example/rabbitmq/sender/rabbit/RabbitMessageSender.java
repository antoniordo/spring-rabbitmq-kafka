package com.example.rabbitmq.sender.rabbit;

import com.example.rabbitmq.sender.MessageSender;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class RabbitMessageSender implements MessageSender {
    
    private RabbitTemplate rabbitTemplate;
    private Queue queue;
    
    public RabbitMessageSender(RabbitTemplate rabbitTemplate, Queue queue) {
        this.rabbitTemplate = rabbitTemplate;
        this.queue = queue;
    }
    
    @Override
    public void send(String message) {
        rabbitTemplate.convertAndSend(queue.getName(), message);
    }
}
