package com.sm.journalApp.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTests {
    @Autowired
    private EmailService emailService;

    @Test
    void TestSendEmail() {
        emailService.sendEmail("subham.mathpal@tekmindz.com", "Testing java email sender", "how are you");
    }
}
