package com.webperside.blogsite.service.util;

import org.springframework.stereotype.Service;

@Service
public class MailService {

    // implement rabbit mq

    public void send(String to, String body){
        System.out.println("to, " + to);
        System.out.println("body, " + body);
    }
}
