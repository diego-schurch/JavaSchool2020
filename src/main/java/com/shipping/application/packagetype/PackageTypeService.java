package com.shipping.application.packagetype;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PackageTypeService {

    @Autowired
    private PackageTypeDao packageTypeDao;


    public List<String> getPackageTypes() throws JsonProcessingException {
        ArrayList<String> packageTypes = new ArrayList<>();

        for (PackageType packageType: this.packageTypeDao.getPackageTypes()) {
            packageTypes.add(packageType.getDescription());
        }
        return packageTypes;

    }

}
