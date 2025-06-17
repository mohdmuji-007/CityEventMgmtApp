package com.example.city_event_mgmt_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.city_event_mgmt_app.model.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    List<Registration> findByUserId(Long userId);
    List<Registration> findByEventId(Long eventId);
}

