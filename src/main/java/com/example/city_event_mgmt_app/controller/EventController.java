package com.example.city_event_mgmt_app.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.city_event_mgmt_app.model.Event;
import com.example.city_event_mgmt_app.model.User;
import com.example.city_event_mgmt_app.service.EventService;
import com.example.city_event_mgmt_app.service.UserService;

@Controller
@RequestMapping("/events")
public class EventController {
    @Autowired
    private EventService eventService;
    
    @Autowired
    private UserService userService;

    @GetMapping
    public String listEvents(Model model) {
        List<Event> events = eventService.getAllEvents();
        model.addAttribute("events", events);
        model.addAttribute("categories", List.of("Music", "Sports", "Festival", "Conference")); // Example categories
        return "events";
    }


    @GetMapping("/category")
    public String getEventsByCategory(@RequestParam String category, Model model) {
        List<Event> events = eventService.getEventsByCategory(category);
        model.addAttribute("events", events);
        model.addAttribute("categories", List.of("Music", "Sports", "Festival", "Conference")); // Example categories
        return "events";
    }



    @GetMapping("/date")
    public String getEventsByDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, Model model) {
        model.addAttribute("events", eventService.getEventsByDate(date));
        return "events";
    }

    @GetMapping("/details/{id}")
    public String eventDetails(@PathVariable Long id, Model model) {
        Event event = eventService.getEventById(id);
        User user = userService.getUserById(1L); // Replace with logged-in user logic if available

        if (event == null) {
            throw new IllegalArgumentException("Event not found!");
        }

        model.addAttribute("event", event);
        model.addAttribute("user", user);
        return "eventDetails";
    }

}

