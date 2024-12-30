package com.openweathermap.project.params;

import com.openweathermap.project.models.AppId;
import com.openweathermap.project.models.Location;
import com.openweathermap.project.models.Units;

public record GetWeatherParams(Location location, AppId appId, Units units) {

    public static GetWeatherParams of(Location location, AppId appId, Units units) {
        return new GetWeatherParams(location,appId,units);
    }
}