package com.openweathermap.project.models;

public record Location(String value) {

    public static Location of(String value) {
        return new Location(value);
    }
}