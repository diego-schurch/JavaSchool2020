package com.shipping.application.controller;

import com.shipping.application.service.TransportTypeService;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransportTypeController {

    @Autowired
    private TransportTypeService transportTypeService;

    @GetMapping(value = "/transport/{packageSize}", produces= {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity getTransportTypes(@PathVariable String packageSize) throws JsonProcessingException {

        return new ResponseEntity(this.transportTypeService.getTransportTypes(packageSize), HttpStatus.OK);

    }

}
