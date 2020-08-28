package com.shipping.application.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.shipping.application.model.PackageTypeModel;
import com.shipping.application.repository.PackageTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PackageTypeDao {

    @Autowired
    private PackageTypeRepository packageTypeRepository;

    public List<PackageTypeModel> getPackageTypes() throws JsonProcessingException {
        return packageTypeRepository.getPackageTypes();
    }

}
