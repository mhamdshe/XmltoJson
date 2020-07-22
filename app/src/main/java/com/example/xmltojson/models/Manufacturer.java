package com.example.xmltojson.models;

public class Manufacturer {
    String Name;
    String DisplayOrder;

    public Manufacturer() {
    }

    public Manufacturer(String name, String displayOrder) {
        Name = name;
        DisplayOrder = displayOrder;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDisplayOrder() {
        return DisplayOrder;
    }

    public void setDisplayOrder(String displayOrder) {
        DisplayOrder = displayOrder;
    }
}
