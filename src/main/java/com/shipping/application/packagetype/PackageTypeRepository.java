package com.shipping.application.packagetype;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shipping.application.util.rabbitmq.RabbitMQRequestMessage;
import com.shipping.application.util.rabbitmq.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class PackageTypeRepository {

    @Autowired
    RabbitMQSender sender;

    private ObjectMapper mapper = new ObjectMapper();

    public List<PackageType> getPackageTypes() throws JsonProcessingException {

        RabbitMQRequestMessage requestMessage = new RabbitMQRequestMessage("packageType");
        String receivedMessage = sender.sendRequest(requestMessage);

        List<PackageType> packageTypes = mapper.readValue(receivedMessage, new TypeReference<List<PackageType>>(){});

        return packageTypes;

    }
}
