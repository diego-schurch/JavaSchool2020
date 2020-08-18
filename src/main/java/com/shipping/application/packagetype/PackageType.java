package com.shipping.application.packagetype;


//This is the class that i have to use for deserializer
public class PackageType {

    private int id;
    private String description;
    private int price;

    public int getId(){
        return this.id;
    }

    public String getDescription(){
        return this.description;
    }

    public int getPrice(){
        return this.price;
    }

}
