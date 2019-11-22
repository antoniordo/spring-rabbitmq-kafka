package com.example.rabbitmq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StopWatch;

@RabbitListener(queues = "hello")
public class ReceiverComponent {
    
    private final int instance;
    
    @Value("#{new Boolean('${worker.throwError}')}")
    private boolean throwError;
    
    public ReceiverComponent(int i) {
        this.instance = i;
    }
    
    @RabbitHandler
    public void receive(String in) throws InterruptedException {
        System.out.println("throwError=" + throwError);
        StopWatch watch = new StopWatch();
        watch.start();
        System.out.println("instance " + this.instance + " [x] Received '" + in + "'");
        doWork(in);
        watch.stop();
        if (throwError) {
            throw new RuntimeException("Error thrown on queue message: " + in);
        }
        System.out.println("instance " + this.instance + " [x] Done in " + watch.getTotalTimeSeconds() + "s");
    }
    
    private void doWork(String in) throws InterruptedException {
        for (char ch : in.toCharArray()) {
            if (ch == '.') {
                Thread.sleep(1000);
            }
        }
    }
    
}
