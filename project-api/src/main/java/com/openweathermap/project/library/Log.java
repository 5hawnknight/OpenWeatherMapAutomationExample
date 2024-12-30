package com.openweathermap.project.library;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.function.Consumer;

public interface Log {

    default Logger logger() {
        return LoggerFactory.getLogger(this.getClass().getSimpleName());
    }

    default void log(String message) {
        logger().info(message);
    }

    static <T> Logger logger(Class<T> clazz) {
        return LoggerFactory.getLogger(clazz);
    }

    default void setLogFile(String name) {
        MDC.put("file-name",name);
    }
    Consumer<String> setLogFile = name -> MDC.put("file-name",name);
}