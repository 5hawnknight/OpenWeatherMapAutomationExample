package com.openweathermap.project.tests.weatherapi;

import com.openweathermap.project.library.ConfigurationFactory;
import com.openweathermap.project.params.GetWeatherParams;
import com.openweathermap.project.responses.GetWeatherResponse;
import com.openweathermap.project.store.RandomDataGenerator;
import com.openweathermap.project.tests.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;

public class ValidResponseSchemaCheck implements BaseTest {

    private GetWeatherResponse response;

    @BeforeEach
    public void setup() {
        var params = GetWeatherParams.of(RandomDataGenerator.getRandomLocation(),
                ConfigurationFactory.appId,
                ConfigurationFactory.units);
        response = getWeather.apply(params);
    }

    @Test
    @DisplayName("Verify Random WeatherAPI Request With Known Response Schema")
    public void weatherAPISchemaCheck() {
        assertThat(response.response().getStatus()).isEqualTo(200);
        assertThat(response.body(), matchesJsonSchemaInClasspath("weather.api.schema.json"));
    }
}