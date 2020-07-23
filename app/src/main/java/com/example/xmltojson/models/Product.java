package com.example.xmltojson.models;

import java.util.ArrayList;

public class Product {
    public String mainCategory;
    public String vat;
    public String tax;
    public String weight;
    public String price;
    public String oldPrice;
    public String stockQuantity;
    public String currency;
    public String fullDescription;
    public String shortDescription;
    public String name;
    public String gtin;
    public String color;
    public String sku;
    public String modelCode;
    public String id;
    public Category category;
    Manufacturer manufacturer;
    public String editorNote;
    public String description;
    ArrayList<Picture> pictures;
    ArrayList<Combination> combinations;
    ArrayList<Specification> specifications;

    public Product() {
    }

    public Product(String content, String mainCategory, String vat, String tax, String weight, String price, String oldPrice, String stockQuantity, String currency, String fullDescription, String shortDescription, String name, String gtin, String color, String sku, String modelCode, String id, Category categories, Manufacturer manufacturers, ArrayList<Picture> pictures, ArrayList<Combination> combinations, ArrayList<Specification> specifications, String editorNote, String description) {
        this.mainCategory = mainCategory;
        this.vat = vat;
        this.tax = tax;
        this.weight = weight;
        this.price = price;
        this.oldPrice = oldPrice;
        this.stockQuantity = stockQuantity;
        this.currency = currency;
        this.fullDescription = fullDescription;
        this.shortDescription = shortDescription;
        this.name = name;
        this.gtin = gtin;
        this.color = color;
        this.sku = sku;
        this.modelCode = modelCode;
        this.id = id;
        category = categories;
        manufacturer = manufacturers;
        this.pictures = pictures;
        this.combinations = combinations;
        this.specifications = specifications;
        this.editorNote = editorNote;
        this.description = description;
    }


    public String getMainCategory() {
        return mainCategory;
    }

    public void setMainCategory(String mainCategory) {
        this.mainCategory = mainCategory;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(String stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGtin() {
        return gtin;
    }

    public void setGtin(String gtin) {
        this.gtin = gtin;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public ArrayList<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(ArrayList<Picture> pictures) {
        this.pictures = pictures;
    }

    public ArrayList<Combination> getCombinations() {
        return combinations;
    }

    public void setCombinations(ArrayList<Combination> combinations) {
        this.combinations = combinations;
    }

    public ArrayList<Specification> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(ArrayList<Specification> specifications) {
        this.specifications = specifications;
    }

    public String getEditorNote() {
        return editorNote;
    }

    public void setEditorNote(String editorNote) {
        this.editorNote = editorNote;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
