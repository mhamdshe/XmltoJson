package com.example.xmltojson.models;

import java.util.ArrayList;

public class Categories {

    ArrayList<Category> Category;



    public ArrayList<com.example.xmltojson.models.Category> getCategory() {
        return Category;
    }

    public void setCategory(ArrayList<com.example.xmltojson.models.Category> category) {
        Category = category;
    }

    public Categories( ArrayList<com.example.xmltojson.models.Category> category) {
        Category = category;
    }

    public Categories() {
    }
}
