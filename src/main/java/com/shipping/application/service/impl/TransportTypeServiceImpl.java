package com.shipping.application.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.shipping.application.repository.TransportTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shipping.application.service.TransportTypeService;

import java.util.stream.Stream;

@Component
public class TransportTypeServiceImpl implements TransportTypeService {

    @Autowired
    private TransportTypeRepository transportTypeRepository;

    @Override
    public Stream<String> getTransportTypes(String packageSize) throws JsonProcessingException {

        return this.transportTypeRepository.getTransportTypes(packageSize).stream()
                .map(transportType -> transportType.getDescription() );

    }
}
