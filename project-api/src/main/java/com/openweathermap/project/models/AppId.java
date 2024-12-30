package com.openweathermap.project.models;

public record AppId(String value) {

    public static AppId of(String value) {
        return new AppId(value);
    }
}