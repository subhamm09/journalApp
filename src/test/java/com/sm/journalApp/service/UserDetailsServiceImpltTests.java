package com.sm.journalApp.service;

import com.sm.journalApp.entity.User;
import com.sm.journalApp.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ActiveProfiles("dev")
public class UserDetailsServiceImpltTests {

    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach()
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void loadUserByUsernameTest() {
        when(userRepository.findByUserName(ArgumentMatchers.anyString()))
                .thenReturn(User.builder().userName("ram").password("test").roles(new ArrayList<>()).build());
        UserDetails userDetails = userDetailsService.loadUserByUsername("ram");
        assertNotNull(userDetails);
    }
}
