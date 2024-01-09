package com.automationexercisepom.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.io.File;
import java.io.IOException;

public class BrowserManager {

    public static WebDriver doBrowserSetup() throws IOException {
        WebDriver driver = null;
        String name = PropertiesLoader.loadProperty("browser.name");
        if (name.equalsIgnoreCase("Chrome")) {


            System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\QA\\AutomationExercisePom\\src\\test\\resources\\chromedriver.exe");

            //String pathExtension = PropertiesLoader.loadProperty("chrome.extension.adblock.path");

            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");
            chromeOptions.addExtensions(new File("C:\\Users\\HP\\QA\\AutomationExercisePom\\src\\test\\resources\\adblock.crx")); //uBlock Origin
            driver = new ChromeDriver(chromeOptions);

        } else if (name.equalsIgnoreCase("Firefox")) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("--headless");
            firefoxOptions.addArguments("--private");
            driver = new FirefoxDriver(firefoxOptions);
        }
        return driver;
    }
}

