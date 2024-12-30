package com.openweathermap.project.models;

public record City(String value) {

    public static City of(String value) {
        return new City(value);
    }
}