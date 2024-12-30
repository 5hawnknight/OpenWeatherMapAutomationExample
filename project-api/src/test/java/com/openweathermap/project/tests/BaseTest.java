package com.openweathermap.project.tests;

import com.openweathermap.project.apis.WeatherAPI;
import com.openweathermap.project.library.ConfigurationFactory;
import com.openweathermap.project.library.Log;
import com.openweathermap.project.library.UnirestHandler;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public interface BaseTest extends ConfigurationFactory, WeatherAPI, Log {

    @BeforeEach
    default void setLogFile() {
        setLogFile(this.getClass().getSimpleName());
    }

    @AfterEach
    default void afterEach() {
        UnirestHandler.instance().close();
    }
}