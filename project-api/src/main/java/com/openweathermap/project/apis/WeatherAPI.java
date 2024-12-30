package com.openweathermap.project.apis;

import com.openweathermap.project.library.ConfigurationFactory;
import com.openweathermap.project.library.Log;
import com.openweathermap.project.library.UnirestHandler;
import com.openweathermap.project.params.GetWeatherParams;
import com.openweathermap.project.responses.GetWeatherResponse;
import org.slf4j.Logger;

import java.util.function.Function;

public interface WeatherAPI extends ConfigurationFactory, Log {

    private static Logger _logger() {
        return Log.logger(WeatherAPI.class);
    }

    Function<GetWeatherParams, GetWeatherResponse> getWeather = params -> {
        var request = UnirestHandler.instance()
                .get(baseURL.concat("/data/2.5/weather"))
                .queryString("q", params.location().value())
                .queryString("appid",params.appId().value())
                .queryString("units", params.units().value());
        _logger().info("Request:\n".concat(request.toSummary().asString()));
        var response = request.asJson();
        _logger().info("Response Body:\n".concat(response.getBody().toPrettyString()));
        return GetWeatherResponse.of(response);
    };
}