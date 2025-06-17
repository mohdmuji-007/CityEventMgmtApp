package com.example.city_event_mgmt_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.city_event_mgmt_app.model.Event;
import com.example.city_event_mgmt_app.service.EventService;

@Controller
@RequestMapping("/admin/events")
public class AdminController {
    @Autowired
    private EventService eventService;

    @GetMapping
    public String listEvents(Model model) {
        model.addAttribute("events", eventService.getAllEvents());
        return "adminEvents";
    }

    @GetMapping("/add")
    public String showEventCreationForm(Model model) {
        model.addAttribute("event", new Event());
        return "addEvent";
    }

    @PostMapping("/save")
    public String createEvent(@ModelAttribute Event event) {
        eventService.createEvent(event);
        return "redirect:/admin/events";
    }

    @GetMapping("/edit/{id}")
    public String editEvent(@PathVariable Long id, Model model) {
        model.addAttribute("event", eventService.getEventById(id));
        return "editEvent";
    }

    @PostMapping("/update/{id}")
    public String updateEvent(@PathVariable Long id, @ModelAttribute Event event) {
        event.setId(id);
        eventService.updateEvent(event);
        return "redirect:/admin/events";
    }

    @GetMapping("/delete/{id}")
    public String deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return "redirect:/admin/events";
    }

}

