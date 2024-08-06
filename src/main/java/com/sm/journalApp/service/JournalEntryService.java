package com.sm.journalApp.service;

import com.sm.journalApp.entity.JournalEntryV2;
import com.sm.journalApp.entity.User;
import com.sm.journalApp.repository.JournalEntryRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(JournalEntryService.class);

    public void saveEntry(JournalEntryV2 journalEntryV2, String userName) {
        try {
            User user = userService.findByUserName(userName);
            journalEntryV2.setDate(LocalDateTime.now());
            JournalEntryV2 save = journalEntryRepository.save(journalEntryV2);
            user.getJournalEntries().add(save);
            userService.saveNewEntry(user);
        } catch (Exception e) {
            log.error("Exception ", e);
            throw new RuntimeException("Something has gone wrong", e);
        }
    }

    public void saveEntry(JournalEntryV2 journalEntryV2) {
        try {
            journalEntryRepository.save(journalEntryV2);
        } catch (Exception e) {
            log.error("Exception ", e);
        }
    }

    public List<JournalEntryV2> getAll() {
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntryV2> getById(ObjectId id) {
        return journalEntryRepository.findById(id);
    }

    @Transactional
    public boolean deleteById(ObjectId id, String userName) {
        boolean removed = false;
        try {
            User user = userService.findByUserName(userName);
            removed = user.getJournalEntries().removeIf(x -> x.getId().equals(id));
            if (removed) {
                userService.saveEntry(user);
                journalEntryRepository.deleteById(id);
            }
        } catch (Exception e) {
            System.out.println(e);
            log.error("An error occurred while deleting the entry.", e);
        }
        return removed;
    }

}
