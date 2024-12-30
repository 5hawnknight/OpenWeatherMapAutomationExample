package com.openweathermap.project.models;

public record Units(String value) {

    public static Units of(String value) {
        return new Units(value);
    }
}