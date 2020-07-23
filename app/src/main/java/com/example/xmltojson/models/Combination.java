package com.example.xmltojson.models;

public class Combination {
    String stockQuantity;
    String gtin;
    String sku;
    String id;
    String barcode;
    Attribute attribute;

    public Combination() {
    }

    public Combination(String stockQuantity, String gtin, String sku, String id, String barcode, Attribute attribute) {
        this.stockQuantity = stockQuantity;
        this.gtin = gtin;
        this.sku = sku;
        this.id = id;
        this.barcode = barcode;
        this.attribute = attribute;
    }

    public String getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(String stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getGtin() {
        return gtin;
    }

    public void setGtin(String gtin) {
        this.gtin = gtin;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }
}
