package com.example.city_event_mgmt_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.city_event_mgmt_app.service.RegistrationService;

@Controller
@RequestMapping("/register")
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/event")
    public String registerForEvent(@RequestParam Long userId, @RequestParam Long eventId) {
        registrationService.registerForEvent(userId, eventId);
        return "redirect:/users/history/" + userId;
    }




}

