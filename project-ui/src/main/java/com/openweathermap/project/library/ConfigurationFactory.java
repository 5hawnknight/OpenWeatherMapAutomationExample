package com.openweathermap.project.library;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigurationFactory {
    Config configuration = ConfigFactory.load();
    Config environmentConfig = configuration.getConfig(System.getProperty("environment","unknown environment"));
    default String url() {
        if ("local".equalsIgnoreCase(System.getProperty("environment")))
            return String.format(environmentConfig.getString("url"),System.getProperty("user.dir"));
        return environmentConfig.getString("url");
    }
}