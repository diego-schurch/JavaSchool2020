package com.shipping.application.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shipping.application.model.PackageSizeModel;
import com.shipping.application.service.RabbitMQSender;
import com.shipping.application.util.MessageSerializer;
import com.shipping.application.util.RequestPackageSizeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PackageSizeRepository {

    @Autowired
    RabbitMQSender sender;

    private ObjectMapper mapper = new ObjectMapper();

    public List<PackageSizeModel> getPackageSizes(String packageType) throws JsonProcessingException {

        String message = MessageSerializer.requestPackageSizeMessageToPlainTextJson(new RequestPackageSizeMessage("packageSizeByType", packageType));
        String receivedMessage = sender.sendRequest(message);

        List<PackageSizeModel> packageSizes = mapper.readValue(receivedMessage, new TypeReference<List<PackageSizeModel>>(){});

        return packageSizes;

    }
}
