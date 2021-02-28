package com.urunov.activemq.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;

import java.util.concurrent.CountDownLatch;

public class Receiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch(){
        return latch;
    }

    @JmsListener(destination = "helloworld.q")
    public void receive(String message){
        LOGGER.info("received message = '{}' ", message);
        latch.countDown();
    }
}
