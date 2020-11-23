package com.fergueiredo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {
    public void load() {
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties");
            Properties p = new Properties(System.getProperties());
            p.load(inputStream);

            System.setProperties(p);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
