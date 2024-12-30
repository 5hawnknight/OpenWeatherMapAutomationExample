package com.openweathermap.project.tests.weatherapi;

import com.openweathermap.project.library.ConfigurationFactory;
import com.openweathermap.project.models.AppId;
import com.openweathermap.project.params.GetWeatherParams;
import com.openweathermap.project.responses.GetWeatherResponse;
import com.openweathermap.project.store.RandomDataGenerator;
import com.openweathermap.project.tests.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

public class ErrorResponseSchemaCheck implements BaseTest {

    private GetWeatherResponse response;

    @BeforeEach
    public void setup() {
        var params = GetWeatherParams.of(RandomDataGenerator.getRandomLocation(),
                AppId.of("INVALID_APP_ID"),
                ConfigurationFactory.units);
        response = getWeather.apply(params);
    }

    @Test
    @DisplayName("Verify WeatherAPI Response With Invalid AppId Schema Check")
    public void errorResponseSchemaCheck() {
        assertThat(response.status()).isEqualTo(401);
        assertThat(response.body(), matchesJsonSchemaInClasspath("weather.api.error.schema.json"));
    }
}
