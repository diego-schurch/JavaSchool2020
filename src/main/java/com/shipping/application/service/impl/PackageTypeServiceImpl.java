package com.shipping.application.service.impl;

import com.shipping.application.model.PackageTypeModel;
import com.shipping.application.dao.PackageTypeDao;
import com.shipping.application.service.PackageTypeService;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PackageTypeServiceImpl implements PackageTypeService {

    @Autowired
    private PackageTypeDao packageTypeDao;

    @Override
    public List<String> getPackageTypes() throws JsonProcessingException {
        ArrayList<String> packageTypes = new ArrayList<>();

        for (PackageTypeModel packageType: this.packageTypeDao.getPackageTypes()) {
            packageTypes.add(packageType.getDescription());
        }
        return packageTypes;

    }
}
