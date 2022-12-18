package com.san.utils;

import com.san.constants.FrameworkConstants;
import com.san.enums.ConfigProperties;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public final class ReadPropertyFileUtils {

    private ReadPropertyFileUtils() {
    }

    private static final Map<String, String> CONFIGMAP = new HashMap<>();

    static { // This block is for loading properties at ONCE and storing all properties in an HashMap.
        try {
            Properties property = new Properties();
            FileInputStream file = new FileInputStream(FrameworkConstants.getConfigPropertyFilePath());
            property.load(file);

            for (Map.Entry<Object, Object> entry:property.entrySet()) {
                CONFIGMAP.put(((String) entry.getKey()).trim(), ((String) entry.getValue()).trim()); //trim is to avoid leading/trailing spaces from property file.
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public static String getValue(ConfigProperties key) throws Exception {
        if(Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) // Here we are doing null check of key/value

            throw new Exception("There is no property available with key: "+key+ " Please check config.properties file");
        return CONFIGMAP.get(key.name().toLowerCase());
    }
}
