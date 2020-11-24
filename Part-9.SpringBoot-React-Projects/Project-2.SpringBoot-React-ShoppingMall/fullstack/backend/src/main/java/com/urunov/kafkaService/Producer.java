package com.urunov.kafkaService;

import com.google.gson.Gson;
import com.urunov.model.Orders;
import com.urunov.payload.SmsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */
@Service
public class Producer {

    private static final Logger LOG = LoggerFactory.getLogger(Producer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${message.topic.requestsms}")
    private String topicRequestSms;

    @Value("${message.topic.portal_orders}")
    private String topicSendOrders;

    public void sendSmsRequest(SmsResponse smsResponse)
    {
        LOG.info("sending message='{}' to topic='{}'", smsResponse, topicRequestSms);
        Gson gson = new Gson();
        kafkaTemplate.send(topicRequestSms, gson.toJson(smsResponse));
    }

    public void sendOrderRequest(Orders orders)
    {
        LOG.info("sending message='{}' to topic='{}'", orders, topicSendOrders);
        Gson gson = new Gson();
        kafkaTemplate.send(topicSendOrders, gson.toJson(new OrderKafkaResponse(orders)));
    }

}
