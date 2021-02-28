package com.urunov.jwtauth.gitProxyStore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;

@RequestMapping("/api/publish")
@RestController
public class PublisherImplementation {

    @Autowired
    private JmsTemplate jmsTemplate;


    @Autowired
    private Queue queue;

    @GetMapping("/{msg}")
    public String publishMessage(@PathVariable("msg") String content )
    {
        jmsTemplate.convertAndSend(queue, content);
        return "Success";
    }
}
