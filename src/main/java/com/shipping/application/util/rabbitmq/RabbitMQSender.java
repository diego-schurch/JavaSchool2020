package com.shipping.application.util.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RabbitMQSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static final Logger logger = LoggerFactory.getLogger(RabbitMQSender.class);

    public String sendRequest(RabbitMQRequestMessage message) {

        String receivedMessage = (String)rabbitTemplate.convertSendAndReceive(message.toString());
        return receivedMessage;

    }

}
