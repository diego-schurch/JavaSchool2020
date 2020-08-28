package com.shipping.application.service;

import org.springframework.stereotype.Service;


@Service
public interface RabbitMQSender {

    public String sendRequest(String message);

}
