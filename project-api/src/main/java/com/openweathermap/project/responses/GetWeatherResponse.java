package com.openweathermap.project.responses;

import kong.unirest.core.HttpResponse;
import kong.unirest.core.JsonNode;

public record GetWeatherResponse(HttpResponse<JsonNode> response) {

    public static GetWeatherResponse of(HttpResponse<JsonNode> response) {
        return new GetWeatherResponse(response);
    }

    public String body() {
        return response.getBody().toPrettyString();
    }

    public Integer status() {
        return response.getStatus();
    }
}