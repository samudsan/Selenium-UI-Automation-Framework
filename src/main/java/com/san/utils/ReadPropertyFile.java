package com.san.utils;

import com.san.constants.FrameworkConstants;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public final class ReadPropertyFile {

    private ReadPropertyFile() {
    }

    private static final Map<String, String> CONFIGMAP = new HashMap<>();

    static { // This block is for loading properties at ONCE and storing all properties in an HashMap.
        try {
            Properties property = new Properties();
            FileInputStream file = new FileInputStream(FrameworkConstants.getConfigPropertyFilePath());
            property.load(file);

            for (Map.Entry<Object, Object> entry:property.entrySet()) {
                CONFIGMAP.put((String) entry.getKey(), (String) entry.getValue());
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public static String getValue(String key) throws Exception {
        if(Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key))) // Here we are doing null check of key/value
            throw new Exception("There is no property available with key: "+key+ " Please check config.properties file");
        return CONFIGMAP.get(key);
    }
}
