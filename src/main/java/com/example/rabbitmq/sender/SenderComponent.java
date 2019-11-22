package com.example.rabbitmq.sender;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.atomic.AtomicInteger;

public class SenderComponent {
    
    private RabbitTemplate template;
    private Queue queue;
    
    AtomicInteger dots = new AtomicInteger(0);
    AtomicInteger count = new AtomicInteger(0);
    
    public SenderComponent(RabbitTemplate template, Queue queue) {
        this.template = template;
        this.queue = queue;
    }
    
    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() {
        StringBuilder builder = new StringBuilder("Hello");
        if (dots.incrementAndGet() == 3) {
            dots.set(1);
        }
        for (int i = 0; i < dots.get(); i++) {
            builder.append('.');
        }
        builder.append(count.incrementAndGet());
        String message = builder.toString();
        template.convertAndSend(queue.getName(), message);
        System.out.println(" [x] Sent '" + message + "'");
    }
    
}
