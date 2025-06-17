package com.example.city_event_mgmt_app.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    private LocalDate registrationDate;

    public Registration() {}

    public Registration(User user, Event event, LocalDate registrationDate) {
        this.user = user;
        this.event = event;
        this.registrationDate = registrationDate;
    }

	public Long getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public Event getEvent() {
		return event;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

    
}

