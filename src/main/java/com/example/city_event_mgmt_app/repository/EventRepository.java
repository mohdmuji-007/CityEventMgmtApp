package com.example.city_event_mgmt_app.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.city_event_mgmt_app.model.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByCategory(String category);
    List<Event> findByDate(LocalDate date);
}

