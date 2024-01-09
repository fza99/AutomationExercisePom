package com.automationexercisepom.tests;

import com.automationexercisepom.utils.BrowserManager;
import com.automationexercisepom.utils.PropertiesLoader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class TestBasic {

    protected static ThreadLocal<WebDriver> tdriver = new ThreadLocal<>();

    public static synchronized WebDriver getDriver() {
        return tdriver.get();
    }

    @BeforeMethod
    public void setup() throws IOException {
        String url = PropertiesLoader.loadProperty("url");
        WebDriver driver = BrowserManager.doBrowserSetup();
        tdriver.set(driver);
        getDriver().get(url);
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
        tdriver.remove();
    }
}
