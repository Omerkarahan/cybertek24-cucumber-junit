package com.cybertek.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties = new Properties();

    static {   // static block can not use non static method
        try {
            // Open the file using inputStream
            FileInputStream inputStream = new FileInputStream("configuration.properties");

            // load to properties object
            properties.load(inputStream);

            // vlose the file after loading. Free up memory
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error occurred while reading configuration file");
        }

    }

    /**
     * Method is used to read valur from a configuration.properties file
     * @param key -> key name in properties file
     * @return -> value for the key. returns if key not found
     * EX: driver.get(ConfigurationReader.getProperty("url")) ;
     */
    public static String getProperty(String key) {
        return properties.getProperty(key);

    }
}
