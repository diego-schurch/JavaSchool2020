package com.shipping.application.model;

import lombok.*;

@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class PackageTypeModel {

    public int id;
    public String description;
    public int price;

}
