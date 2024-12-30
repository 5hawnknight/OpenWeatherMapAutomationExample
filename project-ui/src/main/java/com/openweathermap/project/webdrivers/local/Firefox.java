package com.openweathermap.project.webdrivers.local;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.themelios.core.services.WebDriverType;

public class Firefox  implements WebDriverType {
    @Override
    public WebDriver getWebDriver() {
        FirefoxOptions options = new FirefoxOptions();
        return new FirefoxDriver(options);
    }

    @Override
    public boolean isWebDriverType(String type) {
        return "firefox.local".equalsIgnoreCase(type);
    }
}