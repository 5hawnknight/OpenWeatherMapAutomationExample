package com.openweathermap.project.tests;

import com.openweathermap.project.pageobjects.DashboardPage;
import com.openweathermap.project.library.ConfigurationFactory;
import com.openweathermap.project.library.Log;
import com.openweathermap.project.webdrivers.RegisterLocalWebDrivers;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.themelios.core.services.WebDriverService;
import org.themelios.handlers.DriverHandler;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public interface BaseTest extends ConfigurationFactory, Log {

    default DashboardPage dashboard() {
        return DashboardPage.po.get();
    }

    @BeforeAll
    default void setDriver() {
        DriverHandler.set(new WebDriverService(new RegisterLocalWebDrivers()).createInstance(System.getProperty("browser")));
        DriverHandler.driver().manage().window().maximize();
    }

    @BeforeEach
    default void setLogFile() {
        setLogFile(this.getClass().getSimpleName());
    }

    @BeforeEach
    default void setUrl() {
        var url = switch (System.getProperty("environment")) {
            case "local" -> String.format(environmentConfig.getString("url"),System.getProperty("user.dir"));
            case null -> throw new RuntimeException("environment property is null");
            default -> environmentConfig.getString("url");
        };
        DriverHandler.driver().get(url);
    }
    @AfterAll
    default void quit() {
        DriverHandler.driver().quit();
    }
}
