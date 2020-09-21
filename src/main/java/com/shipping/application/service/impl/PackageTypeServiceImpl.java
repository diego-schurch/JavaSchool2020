package com.shipping.application.service.impl;

import com.shipping.application.repository.PackageTypeRepository;
import com.shipping.application.service.PackageTypeService;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class PackageTypeServiceImpl implements PackageTypeService {

    @Autowired
    private PackageTypeRepository packageTypeRepository;

    @Override
    public Stream<String> getPackageTypes() throws JsonProcessingException {

        return this.packageTypeRepository.getPackageTypes().stream()
                .map(packageType -> packageType.getDescription() );

    }
}
