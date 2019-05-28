package com.webproject.EcommerceSite;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/* Metthods to read properties file and open mentioned Browser*/

public class SeleniumRunConfiguration {

    public WebDriver getRunningBrowser() {
        WebDriver webDriver = null;
        String browser = getBrowserFromPropertiesFile();

        if ( browser.trim().equals("chrome") ) {
            System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe"); //downlaod and add
            webDriver = new ChromeDriver();
        }
        if ( browser.trim().equals("mozilla") || browser.trim().equals("firefox") ) {
            webDriver = new FirefoxDriver();
        }
        if ( browser.trim().equals("IE") ) {
            System.setProperty("webdriver.ie.driver", "driver/IEDriverServer.exe"); //downlaod and add
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            webDriver = new InternetExplorerDriver(capabilities);
        }
        return webDriver;

    }

    public String getBrowserFromPropertiesFile() {
        String propsLocation = "src/test/test.properties";
        Properties prop = new Properties();
        String browser = null;
        try {
            // load a properties file
            prop.load(new FileInputStream(propsLocation));

            // get the property value and print it out
            browser = prop.getProperty("browser");

        } catch ( IOException ex ) {
            ex.printStackTrace();
        }
        return browser;
    }


}
