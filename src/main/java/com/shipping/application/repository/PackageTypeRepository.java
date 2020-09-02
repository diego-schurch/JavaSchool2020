package com.shipping.application.repository;

import com.shipping.application.service.RabbitMQSender;
import com.shipping.application.util.MessageSerializer;
import com.shipping.application.util.RequestMessage;
import com.shipping.application.model.PackageTypeModel;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class PackageTypeRepository {

    @Autowired
    RabbitMQSender sender;

    private ObjectMapper mapper = new ObjectMapper();

    public List<PackageTypeModel> getPackageTypes() throws JsonProcessingException {

        String message = MessageSerializer.requestMessageToPlainTextJson(new RequestMessage("packageType"));
        String receivedMessage = sender.sendRequest(message);

        List<PackageTypeModel> packageTypes = mapper.readValue(receivedMessage, new TypeReference<List<PackageTypeModel>>(){});

        return packageTypes;

    }
}
