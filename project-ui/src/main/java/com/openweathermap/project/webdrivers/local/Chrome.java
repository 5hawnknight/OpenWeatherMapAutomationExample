package com.openweathermap.project.webdrivers.local;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.themelios.core.services.WebDriverType;

public class Chrome implements WebDriverType {
    @Override
    public WebDriver getWebDriver() {
        ChromeOptions options = new ChromeOptions();
        return new ChromeDriver(options);
    }

    @Override
    public boolean isWebDriverType(String type) {
        return "chrome.local".equalsIgnoreCase(type);
    }
}