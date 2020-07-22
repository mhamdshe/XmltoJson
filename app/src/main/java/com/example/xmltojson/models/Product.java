package com.example.xmltojson.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Product {
    public String MainCategory;
    public String VAT;
    public String Tax;
    public String Weight;
    public String Price;
    public String OldPrice;
    public String StockQuantity;
    public String Currency;
    public String FullDescription;
    public String ShortDescription;
    public String Name;
    public String Gtin;
    public String Color;
    public String Sku;
    public String ModelCode;
    public String Id;
    public Categories Categories;
    ArrayList<Manufacturer> Manufacturers;
    ArrayList<Picture> Pictures;
    ArrayList<Combination> Combinations;
    ArrayList<Specification> Specifications;
    public String EditorNote;
    public String Description;

    public Product() {
    }

    public Product(String content, String mainCategory, String VAT, String tax, String weight, String price, String oldPrice, String stockQuantity, String currency, String fullDescription, String shortDescription, String name, String gtin, String color, String sku, String modelCode, String id, Categories categories, ArrayList<Manufacturer> manufacturers, ArrayList<Picture> pictures, ArrayList<Combination> combinations, ArrayList<Specification> specifications, String editorNote, String description) {
        MainCategory = mainCategory;
        this.VAT = VAT;
        Tax = tax;
        Weight = weight;
        Price = price;
        OldPrice = oldPrice;
        StockQuantity = stockQuantity;
        Currency = currency;
        FullDescription = fullDescription;
        ShortDescription = shortDescription;
        Name = name;
        Gtin = gtin;
        Color = color;
        Sku = sku;
        ModelCode = modelCode;
        Id = id;
        Categories = categories;
        Manufacturers = manufacturers;
        Pictures = pictures;
        Combinations = combinations;
        Specifications = specifications;
        EditorNote = editorNote;
        Description = description;
    }



    public String getMainCategory() {
        return MainCategory;
    }

    public void setMainCategory(String mainCategory) {
        MainCategory = mainCategory;
    }

    public String getVAT() {
        return VAT;
    }

    public void setVAT(String VAT) {
        this.VAT = VAT;
    }

    public String getTax() {
        return Tax;
    }

    public void setTax(String tax) {
        Tax = tax;
    }

    public String getWeight() {
        return Weight;
    }

    public void setWeight(String weight) {
        Weight = weight;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getOldPrice() {
        return OldPrice;
    }

    public void setOldPrice(String oldPrice) {
        OldPrice = oldPrice;
    }

    public String getStockQuantity() {
        return StockQuantity;
    }

    public void setStockQuantity(String stockQuantity) {
        StockQuantity = stockQuantity;
    }

    public String getCurrency() {
        return Currency;
    }

    public void setCurrency(String currency) {
        Currency = currency;
    }

    public String getFullDescription() {
        return FullDescription;
    }

    public void setFullDescription(String fullDescription) {
        FullDescription = fullDescription;
    }

    public String getShortDescription() {
        return ShortDescription;
    }

    public void setShortDescription(String shortDescription) {
        ShortDescription = shortDescription;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getGtin() {
        return Gtin;
    }

    public void setGtin(String gtin) {
        Gtin = gtin;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getSku() {
        return Sku;
    }

    public void setSku(String sku) {
        Sku = sku;
    }

    public String getModelCode() {
        return ModelCode;
    }

    public void setModelCode(String modelCode) {
        ModelCode = modelCode;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public Categories getCategories() {
        return Categories;
    }

    public void setCategories(Categories categories) {
        Categories = categories;
    }

    public ArrayList<Manufacturer> getManufacturers() {
        return Manufacturers;
    }

    public void setManufacturers(ArrayList<Manufacturer> manufacturers) {
        Manufacturers = manufacturers;
    }

    public ArrayList<Picture> getPictures() {
        return Pictures;
    }

    public void setPictures(ArrayList<Picture> pictures) {
        Pictures = pictures;
    }

    public ArrayList<Combination> getCombinations() {
        return Combinations;
    }

    public void setCombinations(ArrayList<Combination> combinations) {
        Combinations = combinations;
    }

    public ArrayList<Specification> getSpecifications() {
        return Specifications;
    }

    public void setSpecifications(ArrayList<Specification> specifications) {
        Specifications = specifications;
    }

    public String getEditorNote() {
        return EditorNote;
    }

    public void setEditorNote(String editorNote) {
        EditorNote = editorNote;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
