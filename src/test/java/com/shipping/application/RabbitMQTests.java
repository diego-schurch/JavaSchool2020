package com.shipping.application;

import com.shipping.application.util.rabbitmq.RabbitMQRequestMessage;
import com.shipping.application.util.rabbitmq.RabbitMQSender;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class RabbitMQTests {

    private static final Logger logger = LoggerFactory.getLogger(RabbitMQTests.class);

    @Autowired
    RabbitMQSender sender;

    @Test
    void sendInvalidRequest() {

        RabbitMQRequestMessage message = new RabbitMQRequestMessage("invalidMessage");
        String receivedMessage = sender.sendRequest(message);
        assertNull(receivedMessage);
    }

    @Test
    void sendValidRequest(){

        RabbitMQRequestMessage message = new RabbitMQRequestMessage("packageSize");
        String receivedMessage = sender.sendRequest(message);
        assertNotNull(receivedMessage);

    }
}