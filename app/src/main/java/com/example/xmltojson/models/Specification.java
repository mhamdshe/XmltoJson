package com.example.xmltojson.models;

public class Specification {
    String name;
    String displayOrder;
    String value;

    public Specification() {
    }

    public Specification(String name, String displayOrder, String value) {
        this.name = name;
        this.displayOrder = displayOrder;
        this.value = value;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
