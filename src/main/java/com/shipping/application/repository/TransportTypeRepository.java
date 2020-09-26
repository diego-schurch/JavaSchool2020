package com.shipping.application.repository;

import com.shipping.application.model.TransportTypeModel;
import com.shipping.application.service.RabbitMQSender;
import com.shipping.application.util.MessageSerializer;
import com.shipping.application.util.RequestTransportTypeMessage;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransportTypeRepository {

    @Autowired
    private RabbitMQSender sender;

    private ObjectMapper mapper = new ObjectMapper();

    public List<TransportTypeModel> getTransportTypes(String packageSize) throws JsonProcessingException {

        String message = MessageSerializer.requestMessageToPlainTextJson(new RequestTransportTypeMessage("transportType", packageSize));
        String receivedMessage = sender.sendRequest(message);

        return mapper.readValue(receivedMessage, new TypeReference<List<TransportTypeModel>>(){});

    }
}
