package com.example.city_event_mgmt_app.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.city_event_mgmt_app.model.Event;
import com.example.city_event_mgmt_app.model.Registration;
import com.example.city_event_mgmt_app.model.User;
import com.example.city_event_mgmt_app.repository.EventRepository;
import com.example.city_event_mgmt_app.repository.RegistrationRepository;
import com.example.city_event_mgmt_app.repository.UserRepository;

@Service
@Transactional
public class RegistrationService {
    @Autowired
    private RegistrationRepository registrationRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EventRepository eventRepository;

    public Registration registerForEvent(Long userId, Long eventId) {
        User user = userRepository.findById(userId).orElse(null);
        Event event = eventRepository.findById(eventId).orElse(null);

        if (user == null || event == null) {
            throw new IllegalArgumentException("User or Event not found!");
        }

        if (event.getAvailableSeats() <= 0) {
            throw new IllegalArgumentException("No seats available for this event!");
        }

        event.setAvailableSeats(event.getAvailableSeats() - 1); // Reduce seat count

        Registration registration = new Registration(user, event, LocalDate.now());
        return registrationRepository.save(registration);
    }

    public List<Registration> getRegistrationsByUser(Long userId) {
        return registrationRepository.findByUserId(userId);
    }

    public List<Registration> getRegistrationsByEvent(Long eventId) {
        return registrationRepository.findByEventId(eventId);
    }
}
