package com.shipping.application.controller;


import com.shipping.application.service.PackageSizeService;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PackageSizeController {

    @Autowired
    private PackageSizeService packageSizeService;

    @GetMapping(value = "/size/", produces= {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity getAllPackageSizes() throws JsonProcessingException {

        List<String> packageSizes = this.packageSizeService.getPackageSizes();
        return new ResponseEntity(packageSizes, HttpStatus.OK);

    }
}
