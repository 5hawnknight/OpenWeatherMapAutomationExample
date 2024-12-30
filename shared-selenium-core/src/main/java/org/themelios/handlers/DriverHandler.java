package org.themelios.handlers;

import org.openqa.selenium.WebDriver;

public class DriverHandler {
    private static ThreadLocal<WebDriver> _driver = new ThreadLocal<>();
    public static WebDriver driver() {
        return _driver.get();
    }
    public static void set(WebDriver driver) {
        _driver.set(driver);
    }
}