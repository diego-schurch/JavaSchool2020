package com.shipping.application;

import com.shipping.application.service.RabbitMQSender;
import com.shipping.application.util.MessageSerializer;
import com.shipping.application.util.RequestMessage;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RabbitMQTests {

    private static final Logger logger = LoggerFactory.getLogger(RabbitMQTests.class);

    @Autowired
    RabbitMQSender sender;

    @Test
    void sendInvalidRequest() {

        String message = MessageSerializer.requestMessageToPlainTextJson(new RequestMessage("invalidMessage"));
        String receivedMessage = sender.sendRequest(message);
        assertEquals("Invalid request", receivedMessage);

    }

    @Test
    void sendValidRequest(){

        String message = MessageSerializer.requestMessageToPlainTextJson(new RequestMessage("packageSize"));
        String receivedMessage = sender.sendRequest(message);
        assertNotNull(receivedMessage);

    }
}

