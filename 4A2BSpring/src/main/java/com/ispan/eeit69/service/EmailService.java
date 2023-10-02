package com.ispan.eeit69.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ispan.eeit69.dao.UserDao;
import com.ispan.eeit69.entity.User;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendForgotPasswordEmail(String toEmail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("4A2Beeit69@gmail.com");  // 發件人，通常與你的Gmail帳號相同
        message.setTo("yoyo820701@gmail.com");  // 收件人的郵箱地址
        message.setSubject("重設您的密碼");  // 郵件主題

        // 郵件內容，通常包括一個重設密碼的連結
        String content = "請點擊以下連結來重設您的密碼: " +
                         "http://localhost:8080/reset-password?token=";
        message.setText(content);

        mailSender.send(message);
    }
}