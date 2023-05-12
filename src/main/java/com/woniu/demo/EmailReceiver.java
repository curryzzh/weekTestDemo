package com.woniu.demo;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@EnableRabbit
@Component
public class EmailReceiver {
    @Autowired
    JavaMailSender javaMailSender;
    @RabbitListener(queuesToDeclare = @Queue("email_queue"))
    public void receiveEmail(String email) {
        System.out.println("Received email: " + email);


        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("853818394@qq.com");
        message.setTo("l610622@qq.com");
        message.setSubject("啦啦啦");
        message.setText("发送邮件");

        javaMailSender.send(message);

    }
}
