package com.shipping.application.controller;

import com.shipping.application.service.PackageTypeService;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PackageTypeController {

    @Autowired
    private PackageTypeService packageTypeService;

    @GetMapping(value = "/type", produces= {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity getAllPackageTypes() throws JsonProcessingException {

        return new ResponseEntity(this.packageTypeService.getPackageTypes(), HttpStatus.OK);

    }

}
