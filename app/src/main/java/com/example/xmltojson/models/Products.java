package com.example.xmltojson.models;

import java.util.ArrayList;

public class Products {
    ArrayList<Product> products;
    String category;

    public Products(ArrayList<Product> products, String category) {
        this.products = products;
        this.category = category;
    }

    public Products() {
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
