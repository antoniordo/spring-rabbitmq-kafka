package com.example.rabbitmq.receiver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StopWatch;

public class ReceiverComponent {
    
    @Value("#{new Boolean('${worker.throwError}')}")
    private boolean throwError;
    
    public void receive(String in) {
        System.out.println("throwError=" + throwError);
        StopWatch watch = new StopWatch();
        watch.start();
        System.out.println(" [x] Received '" + in + "'");
        doWork(in);
        watch.stop();
        if (new Boolean(throwError)) {
            throw new RuntimeException("Error thrown on queue message: " + in);
        }
        System.out.println(" [x] Done in " + watch.getTotalTimeSeconds() + "s");
    }
    
    private void doWork(String in) {
        for (char ch : in.toCharArray()) {
            if (ch == '.') {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    
}
