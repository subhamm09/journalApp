package com.sm.journalApp.service;

import com.sm.journalApp.entity.User;
import com.sm.journalApp.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    UserRepository userRepository;

    @Autowired
    JournalEntryService journalEntryService;

    @Autowired
    UserService userService;

    @Test
    @Disabled
    public void testFindByUserName() {
        User user = userRepository.findByUserName("ram");
        assertFalse(user.getJournalEntries().isEmpty());
//        assertEquals(4, 2+2);
        assertNotNull(userRepository.findByUserName("ram"));
//        assertTrue(5>3);
    }

//    @Test
//    @ParameterizedTest
//    @CsvSource({
//            "ram",
//            "subham",
//            "pankaj"})
//    public void testFindByUserName(String name) {
//        User user = userRepository.findByUserName(name);
//        assertTrue(!user.getJournalEntries().isEmpty());
////        assertEquals(4, 2+2);
//        assertNotNull(userRepository.findByUserName(name), "failed for " + name);
////        assertTrue(5>3);
//    }

//    @Test
//    @ParameterizedTest
//    @ValueSource(strings = {
//            "ram",
//            "subham",
//            "pankaj"})
//    public void testFindByUserName(String name) {
//        assertNotNull(userRepository.findByUserName(name), "failed for " + name);
//    }

//    @Test
//    @ParameterizedTest
//    @ValueSource(strings = {
//            "ram",
//            "subham",
//            "pankaj"})
//    public void testFindByUserName(String name) {
//        assertNotNull(userRepository.findByUserName(name), "failed for " + name);
//    }

//    @Test
//    @ParameterizedTest
//    @ArgumentsSource(UserArgumentProvider.class)
//    public void testFindByUserName(String name) {
//        assertNotNull(userRepository.findByUserName(name), "failed for " + name);
//    }

    @ParameterizedTest
    @CsvSource({
            "1, 2, 3",
            "2, 10, 12",
            "5, 5, 9"})
    public void test(int a, int b, int expected) {
        assertEquals(expected, a + b);
    }

    @BeforeEach
    void setUp() {

    }
}
