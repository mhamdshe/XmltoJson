package com.example.xmltojson.models;

public class Picture {
    String Path;

    public Picture() {
    }

    public Picture(String path) {
        Path = path;
    }

    public String getPath() {
        return Path;
    }

    public void setPath(String path) {
        Path = path;
    }
}
