package com.fengdi.keepsheep.util;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Administrator on 2019/3/20.
 */
public class ReadProperties {

    public static String getUrl()throws IOException {
        Properties properties = new Properties();
        properties.load(ReadProperties.class.getClassLoader().getResourceAsStream("db.properties"));
        String name = properties.getProperty("server.host");
        return name;
    }
}
