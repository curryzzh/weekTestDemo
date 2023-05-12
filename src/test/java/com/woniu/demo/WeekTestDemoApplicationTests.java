package com.woniu.demo;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootTest
class WeekTestDemoApplicationTests {
    @Autowired
EmailSender emailSender;
    @Autowired
    EmailReceiver emailReceiver;
    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    void setEmailSender() {
        emailSender.sendEmail("853818394@qq.com");
//        emailReceiver.receiveEmail("853818394@qq.com");
//

    }

    @Test
    void contextLoads() {
        // 简单邮件类
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        // 寄件人，默认是配置的username
        mailMessage.setFrom("853818394@qq.com");
        // 收件人，支持多个收件人
        mailMessage.setTo("853818394@qq.com");
        // 邮件主题
        mailMessage.setSubject("Test simple mail");
        // 邮件的文本信息
        mailMessage.setText("Hello this is test mail from java");

        // 发送邮件
        javaMailSender.send(mailMessage);
    }

}
