package com.example.city_event_mgmt_app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.city_event_mgmt_app.model.User;
import com.example.city_event_mgmt_app.model.UserRole;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    List<User> findByRole(UserRole role);
}

