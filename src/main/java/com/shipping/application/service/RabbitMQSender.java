package com.shipping.application.service;

import com.shipping.application.util.RequestMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public interface RabbitMQSender {

    public String sendRequest(String message);

}
