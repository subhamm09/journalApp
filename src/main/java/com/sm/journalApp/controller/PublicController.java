package com.sm.journalApp.controller;

import com.sm.journalApp.entity.User;
import com.sm.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService;

    @GetMapping("/health-check")
    public String healthCheck() {
        return "Ok";
    }

    @PostMapping("create-user")
    public void createUser(@RequestBody User user) {
        userService.saveEntry(user);
    }
}
