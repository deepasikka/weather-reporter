package main.java.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    private static String filePath = System.getProperty("user.dir")+"/config.properties";
    public static Properties getPropertyObject() throws IOException {
        File file = new File(filePath);
        Properties properties= new Properties();
        FileInputStream fileInputStream = new FileInputStream(file);
        properties.load(fileInputStream);
        return properties;
    }
}
