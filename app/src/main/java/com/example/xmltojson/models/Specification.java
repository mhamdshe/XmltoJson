package com.example.xmltojson.models;

public class Specification {
    String Name;
    String DisplayOrder;
    String Value;

    public Specification() {
    }

    public Specification(String name, String displayOrder, String value) {
        Name = name;
        DisplayOrder = displayOrder;
        Value = value;
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

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }
}
