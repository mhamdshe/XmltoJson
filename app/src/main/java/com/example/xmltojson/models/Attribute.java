package com.example.xmltojson.models;

public class Attribute {
    String Name;
    String Value;

    public Attribute() {
    }

    public Attribute(String name, String value) {
        Name = name;
        Value = value;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }
}
