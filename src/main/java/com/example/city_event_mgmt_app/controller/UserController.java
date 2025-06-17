package com.example.city_event_mgmt_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.city_event_mgmt_app.model.User;
import com.example.city_event_mgmt_app.model.UserRole;
import com.example.city_event_mgmt_app.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registerUser";
    }

    @PostMapping("/save")
    public String registerUser(@ModelAttribute User user) {
        user.setRole(UserRole.USER);  // Default role as regular user
        userService.createUser(user);
        return "redirect:/events";
    }
    
    
    @GetMapping("/{id}")
    public String getUserById(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id);
        if (user == null) {
            throw new IllegalArgumentException("User not found!");
        }
        model.addAttribute("user", user);
        return "userDetails";
    }



    @GetMapping("/history/{userId}")
    public String viewRegistrationHistory(@PathVariable Long userId, Model model) {
        User user = userService.getUserById(userId);
        if (user == null) {
            throw new IllegalArgumentException("User not found!");
        }
        
        model.addAttribute("registrations", user.getRegistrations());
        return "registrationHistory"; // Ensure the template name is correct!
    }

}

