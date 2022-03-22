package com.yangpai.admin.server.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * 邮箱服务实现类
 *
 * @author kuangyoupeng1
 * @date 2022.02.09
 */
@Service
public class EmailService {
    @Value("${spring.mail.username}")
    private String emailHost;

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    /**
     * 邮件发送
     * @param email
     * @param code
     */
    public void sendMail(String email, String code) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailHost);
        message.setTo(email);
        message.setSubject("来自羊排的验证码");
        message.setText("您的验证码为：" + code);
        mailSender.send(message);
    }
}
