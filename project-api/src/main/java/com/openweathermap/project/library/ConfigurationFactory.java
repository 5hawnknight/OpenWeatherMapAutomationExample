package com.openweathermap.project.library;

import com.openweathermap.project.models.AppId;
import com.openweathermap.project.models.Units;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigurationFactory {
    Config configuration = ConfigFactory.load();
    Config environmentConfig = configuration.getConfig(System.getProperty("environment","unknown environment"));
    String baseURL = environmentConfig.getString("base-url");
    AppId appId = AppId.of(ConfigurationFactory.environmentConfig.getString("appid"));
    Units units = Units.of(ConfigurationFactory.environmentConfig.getString("units"));
}