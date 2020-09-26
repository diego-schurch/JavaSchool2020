package com.shipping.application.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public interface TransportTypeService {

    public Stream<String> getTransportTypes(String packageSize) throws JsonProcessingException;

}
