package org.wisetail.utils;

import java.io.*;
import java.util.Properties;

public class CustomProperties extends Properties {
    private String fileLocation;
    private String fileName;

    public CustomProperties(String fileLocation, String fileName) {
        this.fileLocation = fileLocation;
        this.fileName = fileName;
    }

    public CustomProperties(String fileName) {
        this.fileName = fileName;
    }

    public CustomProperties() {
        this.fileName = "test.properties";
        this.fileLocation = "./target/classes/";

    }

    public void loadCustomPropertiesFromFile() {
        try {
            FileReader fileReader = new FileReader(this.fileLocation + this.fileName);
            // FileInputStream in = new FileInputStream(this.fileLocation + this.fileName);
            super.load(fileReader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return super.getProperty(key);
    }
}
