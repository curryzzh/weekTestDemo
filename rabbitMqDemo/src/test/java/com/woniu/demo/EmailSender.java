package com.woniu.demo;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailSender{
    @Autowired
    AmqpTemplate amqpTemplate;
    private static final String QUEUE_NAME = "email_queue";
    @Autowired
    public EmailSender(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }
    public void sendEmail(String email) {
        amqpTemplate.convertAndSend(QUEUE_NAME, email);
        System.out.println("Producer sent email: " + email);
    }


}
