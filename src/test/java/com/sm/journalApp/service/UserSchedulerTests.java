package com.sm.journalApp.service;

import com.sm.journalApp.scheduler.UserScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserSchedulerTests {

    @Autowired
    private UserScheduler userScheduler;

    public void testFetchUserAndSendEmail() {
        userScheduler.fetchUsersAndSendEmail();
    }
}
