package com.openweathermap.project.tests;

import com.openweathermap.project.models.City;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VerifyWeatherApp implements BaseTest {

    City city;

    @BeforeEach
    public void setup() {
        city = City.of("Hays");
        log("city: ".concat(city.value()));
    }
    @Test
    public void testWeatherApp() {
        var actual = dashboard().selectWeatherFor(city).isCityInResults(city);
        assertThat(actual).withFailMessage("expect %s to be in the results table ").isTrue();
    }
}