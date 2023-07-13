package com.example.demo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MoviesController {
    @GetMapping("/")
    public String lamo() {
        return "movies-home";
    }
    @GetMapping(value = "/movies")
    public String movieHome() {
        return "movies-home";
    }
}
