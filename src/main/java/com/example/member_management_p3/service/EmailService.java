package com.example.member_management_p3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    /**
     * @param to
     * @param subject
     * @param messageContent
     * @return
     */
    public String send(String to, String subject, String messageContent) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("sellytranho@gmail.com");
            message.setTo(to);
            message.setText(messageContent);
            message.setSubject(subject);
            mailSender.send(message);
            return messageContent;
        } catch (Exception e) {
            return null;
        }
    }
}