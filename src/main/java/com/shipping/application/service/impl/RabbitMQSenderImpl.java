package com.shipping.application.service.impl;

import com.shipping.application.service.RabbitMQSender;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQSenderImpl implements RabbitMQSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public String sendRequest(String message) {

        String receivedMessage = (String)rabbitTemplate.convertSendAndReceive(message);
        return receivedMessage;

    }
}
