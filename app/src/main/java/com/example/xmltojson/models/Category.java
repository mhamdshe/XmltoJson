package com.example.xmltojson.models;

public class Category {
    String displayOrder;
    String path;

    public Category(String displayOrder, String path) {
        this.displayOrder = displayOrder;
        this.path = path;
    }

    public Category() {
    }

    public String getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(String displayOrder) {
        this.displayOrder = displayOrder;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
