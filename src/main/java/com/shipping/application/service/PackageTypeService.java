package com.shipping.application.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PackageTypeService {

    public List<String> getPackageTypes() throws JsonProcessingException;

}
