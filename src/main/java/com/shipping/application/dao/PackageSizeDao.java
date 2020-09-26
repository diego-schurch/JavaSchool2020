package com.shipping.application.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.shipping.application.model.PackageSizeModel;
import com.shipping.application.repository.PackageSizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PackageSizeDao {

    @Autowired
    private PackageSizeRepository packageSizeRepository;

    public List<PackageSizeModel> getPackageSizes(String packageType) throws JsonProcessingException {
        return packageSizeRepository.getPackageSizes(packageType);
    }

}
