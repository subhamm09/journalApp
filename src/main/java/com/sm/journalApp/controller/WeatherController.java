package com.sm.journalApp.controller;

import com.sm.journalApp.model.WeatherResponse;
import com.sm.journalApp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @GetMapping
    public ResponseEntity<?> greeting() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        WeatherResponse weather = weatherService.getWeather("Mumbai");
        String greetings = "";
        if (Objects.nonNull(weather)) {
            greetings = greetings + ",  weather feels like " + weatherService.getWeather("Mumbai");
        }
        return new ResponseEntity<>("Hi" + authentication.getName() + greetings, HttpStatus.OK);
    }

}
