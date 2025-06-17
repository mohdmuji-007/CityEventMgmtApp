package com.example.city_event_mgmt_app.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String email;
	private String password;
	
	@Enumerated(EnumType.STRING)
	private UserRole role;
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Registration> registrations;
	public User() {
		
	}
	public User(String name, String email, String password, UserRole role) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public UserRole getRole() {
		return role;
	}
	public List<Registration> getRegistrations() {
		return registrations;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setRole(UserRole role) {
		this.role = role;
	}
	public void setRegistrations(List<Registration> registrations) {
		this.registrations = registrations;
	}
	
	
	
	
}
