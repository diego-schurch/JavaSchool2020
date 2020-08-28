package com.shipping.application.controller;

import com.shipping.application.service.PackageTypeService;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PackageTypeController {

    @Autowired
    private PackageTypeService packageTypeService;

    @GetMapping(value = "/package/types", produces= {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity getAllPackageTypes() throws JsonProcessingException {

        List<String> packageTypes = this.packageTypeService.getPackageTypes();
        return new ResponseEntity(packageTypes, HttpStatus.OK);

    }

}
