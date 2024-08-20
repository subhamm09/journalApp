package com.sm.journalApp.service;

import com.sm.journalApp.cache.AppCache;
import com.sm.journalApp.constants.Placeholders;
import com.sm.journalApp.model.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    @Autowired
    private AppCache appCache;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private RedisService redisService;

    public WeatherResponse getWeather(String city) {
        WeatherResponse weatherResponse = redisService.get("weather_of_" + city, WeatherResponse.class);
        if (weatherResponse != null) {
            return weatherResponse;
        } else {
            String finaApi = appCache.appCache.get(AppCache.keys.WEATHER_API.toString())
                    .replace(Placeholders.city, city)
                    .replace(Placeholders.API_KEY, apiKey);
            ResponseEntity<WeatherResponse> response = restTemplate.exchange(finaApi, HttpMethod.GET, null, WeatherResponse.class);
            WeatherResponse body = response.getBody();
            if (body != null) {
                redisService.set("weather_of_" + city, body, 300L);
            }
            return body;
        }

//        HttpHeaders headers = new HttpHeaders();
//        headers.set("key", "value");
//        String requestBody = "{\n" +
//                "    \"userName\":\"DDDDD\",\n" +
//                "    \"password\":\"ram\"\n" +
//                "\n" +
//                "}";
//        HttpEntity<String> httpEntity = new HttpEntity<>(requestBody, headers);
    }
}
