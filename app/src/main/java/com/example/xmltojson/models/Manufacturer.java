package com.example.xmltojson.models;

public class Manufacturer {
    String name;
    String displayOrder;

    public Manufacturer() {
    }

    public Manufacturer(String name, String displayOrder) {
        this.name = name;
        this.displayOrder = displayOrder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(String displayOrder) {
        this.displayOrder = displayOrder;
    }
}
