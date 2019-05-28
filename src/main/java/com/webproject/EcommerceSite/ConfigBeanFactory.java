package com.webproject.EcommerceSite;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


/*Code to read field value from test.properties file and return to SeleniumUtil class or required class*/
public class ConfigBeanFactory {
	static String propsLocation = "src/test/test.properties";
    static Properties prop = new Properties();
	
    public static String getLoginUrl() {
        
        String url = null;
        try {
            // load a properties file
            prop.load(new FileInputStream(propsLocation));

            // get the property value and print it out
            url = prop.getProperty("url");

        } catch ( IOException ex ) {
            ex.printStackTrace();
        }
        return url;
    }

}
