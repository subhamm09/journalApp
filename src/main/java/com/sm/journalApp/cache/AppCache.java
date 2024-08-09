package com.sm.journalApp.cache;

import com.sm.journalApp.entity.ConfigJournalApp;
import com.sm.journalApp.repository.ConfigJournalAppRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AppCache {
    public Map<String, String> appCache;
    @Autowired
    private ConfigJournalAppRepository configJournalAppRepository;

    @PostConstruct
    public void init() {
        appCache = new HashMap<>();
        List<ConfigJournalApp> all = configJournalAppRepository.findAll();
        for (ConfigJournalApp configJournalApp : all) {
            appCache.put(configJournalApp.getKey(), configJournalApp.getValue());
        }
    }

    public enum keys {
        WEATHER_API
    }

}
