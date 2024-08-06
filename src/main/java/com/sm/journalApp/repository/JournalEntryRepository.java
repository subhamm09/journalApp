package com.sm.journalApp.repository;

import com.sm.journalApp.entity.JournalEntryV2;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepository extends MongoRepository<JournalEntryV2, ObjectId> {
}
