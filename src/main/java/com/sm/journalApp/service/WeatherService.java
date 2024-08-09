package com.sm.journalApp.service;

import com.sm.journalApp.model.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    private static final String API = "http://api.weatherstack.com/current?accesskey=API_KEY&query=CITY";

    @Autowired
    private RestTemplate restTemplate;

    public WeatherResponse getWeather(String city) {
        String finaApi = API.replace("CITY", city).replace("API_KEY", apiKey);
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("key", "value");
//        String requestBody = "{\n" +
//                "    \"userName\":\"DDDDD\",\n" +
//                "    \"password\":\"ram\"\n" +
//                "\n" +
//                "}";
//        HttpEntity<String> httpEntity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finaApi, HttpMethod.GET, null, WeatherResponse.class);
        return response.getBody();
    }
}
