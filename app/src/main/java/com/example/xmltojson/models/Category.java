package com.example.xmltojson.models;

public class Category {
    String DisplayOrder;
    String Path;

    public Category(String displayOrder, String path) {
        DisplayOrder = displayOrder;
        Path = path;
    }

    public Category(String displayOrder) {
        DisplayOrder = displayOrder;
    }

    public String getDisplayOrder() {
        return DisplayOrder;
    }

    public void setDisplayOrder(String displayOrder) {
        DisplayOrder = displayOrder;
    }

    public String getPath() {
        return Path;
    }

    public void setPath(String path) {
        Path = path;
    }
}
