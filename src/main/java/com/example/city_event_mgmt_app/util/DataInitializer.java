package com.example.city_event_mgmt_app.util;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.city_event_mgmt_app.model.Event;
import com.example.city_event_mgmt_app.model.Registration;
import com.example.city_event_mgmt_app.model.User;
import com.example.city_event_mgmt_app.model.UserRole;
import com.example.city_event_mgmt_app.repository.EventRepository;
import com.example.city_event_mgmt_app.repository.RegistrationRepository;
import com.example.city_event_mgmt_app.repository.UserRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private RegistrationRepository registrationRepository;

    @Override
    public void run(String... args) {
        if (userRepository.count() == 0 && eventRepository.count() == 0) {
            // Create Users
            User admin = new User("Admin User", "admin@example.com", "admin123", UserRole.ADMIN);
            User user1 = new User("John Doe", "john@example.com", "password123", UserRole.USER);
            User user2 = new User("Jane Smith", "jane@example.com", "password456", UserRole.USER);
            userRepository.saveAll(List.of(admin, user1, user2));

            // Create Events
            Event concert = new Event("Music Concert", "Live band performance", "Central Park", LocalDate.of(2025, 5, 15), "Music", 100);
            Event marathon = new Event("City Marathon", "Annual running event", "Downtown", LocalDate.of(2025, 6, 10), "Sports", 200);
            eventRepository.saveAll(List.of(concert, marathon));

            // Register Users for Events
            Registration reg1 = new Registration(user1, concert, LocalDate.now());
            Registration reg2 = new Registration(user2, marathon, LocalDate.now());
            registrationRepository.saveAll(List.of(reg1, reg2));

            System.out.println("✅ Sample users, events, and registrations inserted successfully!");
        } else {
            System.out.println("⚠️ Sample data already exists, skipping insertion.");
        }
    }
}

