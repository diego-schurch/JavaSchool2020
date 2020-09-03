package com.shipping.application.service.impl;

import com.shipping.application.dao.PackageSizeDao;
import com.shipping.application.model.PackageSizeModel;
import com.shipping.application.repository.PackageSizeRepository;

import com.shipping.application.service.PackageSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PackageSizeServiceImpl implements PackageSizeService {

    @Autowired
    private PackageSizeDao packageSizeDao;

    @Override
    public List<String> getPackageSizes() throws JsonProcessingException {

        ArrayList<String> packageSizes = new ArrayList<>();

        for (PackageSizeModel packageSize: this.packageSizeDao.getPackageSizes()) {
            packageSizes.add(packageSize.getDescription());
        }

        return packageSizes;

    }
}
