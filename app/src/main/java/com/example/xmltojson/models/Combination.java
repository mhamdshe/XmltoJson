package com.example.xmltojson.models;

import java.util.ArrayList;
import java.util.jar.Attributes;

public class Combination {
    String StockQuantity;
    String Gtin;
    String Sku;
    String Id;
    String Barcode;
    ArrayList<Attribute> Attributes;

    public Combination() {
    }

    public Combination(String stockQuantity, String gtin, String sku, String id, String barcode, ArrayList<Attribute> attributes) {
        StockQuantity = stockQuantity;
        Gtin = gtin;
        Sku = sku;
        Id = id;
        Barcode = barcode;
        Attributes = attributes;
    }

    public String getStockQuantity() {
        return StockQuantity;
    }

    public void setStockQuantity(String stockQuantity) {
        StockQuantity = stockQuantity;
    }

    public String getGtin() {
        return Gtin;
    }

    public void setGtin(String gtin) {
        Gtin = gtin;
    }

    public String getSku() {
        return Sku;
    }

    public void setSku(String sku) {
        Sku = sku;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getBarcode() {
        return Barcode;
    }

    public void setBarcode(String barcode) {
        Barcode = barcode;
    }

    public ArrayList<Attribute> getAttributes() {
        return Attributes;
    }

    public void setAttributes(ArrayList<Attribute> attributes) {
        Attributes = attributes;
    }
}
