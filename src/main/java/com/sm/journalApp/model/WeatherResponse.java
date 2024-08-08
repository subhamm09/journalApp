package com.sm.journalApp.model;

import lombok.Data;

import java.util.List;

@Data
public class WeatherResponse {
    private Current current;

    @Data
    public static class Current {
        private int temperature;
        private List<String> weatherDescription;
        private int feelsLike;
    }
}
