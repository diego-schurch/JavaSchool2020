package com.shipping.application.service.impl;

import com.shipping.application.repository.PackageSizeRepository;

import com.shipping.application.service.PackageSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class PackageSizeServiceImpl implements PackageSizeService {

    @Autowired
    private PackageSizeRepository packageSizeRepository;

    @Override
    public Stream<String> getPackageSizes(String packageType) throws JsonProcessingException {

        return this.packageSizeRepository.getPackageSizes(packageType).stream()
                .map(packageSize -> packageSize.getDescription() );

    }
}
