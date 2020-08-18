package com.shipping.application.packagetype;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PackageTypeDao {

    @Autowired
    private PackageTypeRepository packageTypeRepository;

    public List<PackageType> getPackageTypes() throws JsonProcessingException {
        return packageTypeRepository.getPackageTypes();
    }



}
