package com.example.city_event_mgmt_app.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String description;
	private String location;
	private LocalDate date;
	private String category;
	private int availableSeats;
	@OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
	private List <Registration> registrations;
	public Event() {
		
	}
	public Event(String title, String description, String location, LocalDate date, String category,
			int availableSeats) {
		this.title = title;
		this.description = description;
		this.location = location;
		this.date = date;
		this.category = category;
		this.availableSeats = availableSeats;
	}
	public Long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
	}
	public String getLocation() {
		return location;
	}
	public LocalDate getDate() {
		return date;
	}
	public String getCategory() {
		return category;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public List<Registration> getRegistrations() {
		return registrations;
	}
	public void setId(Long id2) {
		this.id = id2;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	public void setRegistrations(List<Registration> registrations) {
		this.registrations = registrations;
	}
	
	
	
}
