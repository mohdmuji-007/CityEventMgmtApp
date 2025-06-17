package com.example.city_event_mgmt_app.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.city_event_mgmt_app.model.Event;
import com.example.city_event_mgmt_app.repository.EventRepository;

@Service
@Transactional
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public List<Event> getEventsByCategory(String category) {
        return eventRepository.findByCategory(category);
    }

    public List<Event> getEventsByDate(LocalDate date) {
        return eventRepository.findByDate(date);
    }

    public void updateEvent(Event event) {
        eventRepository.save(event);
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}

