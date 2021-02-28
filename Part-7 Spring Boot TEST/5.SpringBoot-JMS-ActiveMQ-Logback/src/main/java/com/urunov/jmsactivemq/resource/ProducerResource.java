package com.urunov.jmsactivemq.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;
import java.util.Queue;

@RestController
@RequestMapping("/rest/publish")
public class ProducerResource {
    //
    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    Queue queue;

    @GetMapping("/message")
    public String publish(@PathVariable("message") final  String message){
        jmsTemplate.convertAndSend((Destination) queue, message);
        return "Published Successfully";
    }
}