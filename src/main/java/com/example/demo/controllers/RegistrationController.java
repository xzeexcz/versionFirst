package com.example.demo.controllers;

import com.example.demo.entities.impls.User;
import com.example.demo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class RegistrationController {
    private final UserService userService;

    @GetMapping(value = "/register")
    public String registrationPage() {
        return "register";
    }

    @PostMapping(value = "/register")
    public String registration(@RequestParam(name = "user_first_name") String firstName,
                               @RequestParam(name = "user_last_name") String lastName,
                               @RequestParam(name = "user_email") String email,
                               @RequestParam(name = "user_password") String password
                               ) {
            User user = userService.addUser(email, password, firstName, lastName);
            if (user == null) {
                return "redirect:/register?error";
            } else {
                return "movies-home";
            }
        }
    }
