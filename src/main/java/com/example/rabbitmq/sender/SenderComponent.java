package com.example.rabbitmq.sender;

import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.atomic.AtomicInteger;

public class SenderComponent {
    
    private AtomicInteger dots = new AtomicInteger(0);
    private AtomicInteger count = new AtomicInteger(0);
    
    private MessageSender messageSender;
    
    public SenderComponent(MessageSender messageSender) {
        this.messageSender = messageSender;
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
        messageSender.send(message);
        System.out.println(" [x] Sent '" + message + "'");
    }
    
}
