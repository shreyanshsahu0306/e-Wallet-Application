package com.example.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class EmailConfig {

    @Bean
    SimpleMailMessage getEmailMessage(){
        return new SimpleMailMessage();
    }

    @Bean
    JavaMailSender getMailSender(){
        JavaMailSenderImpl jms = new JavaMailSenderImpl();
        jms.setHost("smtp.gmail.com");
        jms.setPort(586);
        jms.setUsername("shrnshsahu@gmail.com");
        jms.setPassword("xtyr wsqw xeie ialz");

        Properties prop = jms.getJavaMailProperties();
        prop.put("mail.debug", true);
        prop.put("mail.smtpstarttls.enable", true); //enabling transport layer security to send emails from app

        return jms;
    }
}
