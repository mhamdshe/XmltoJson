package com.example.xmltojson.models;

public class Combination {
    String StockQuantity;
    String Gtin;
    String Sku;
    String Id;
    String Barcode;
    Attribute attribute;

    public Combination() {
    }

    public Combination(String stockQuantity, String gtin, String sku, String id, String barcode, Attribute attribute) {
        StockQuantity = stockQuantity;
        Gtin = gtin;
        Sku = sku;
        Id = id;
        Barcode = barcode;
        this.attribute = attribute;
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

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }
}
