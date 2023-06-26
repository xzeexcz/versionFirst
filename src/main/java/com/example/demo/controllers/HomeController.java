package com.example.demo.controllers;


import com.example.demo.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final MovieService movieService;

    @GetMapping(value = "/lol/{id}")
    public String home(@PathVariable(name = "id") String url, Model model) {
        model.addAttribute("lol", movieService.lol(url));
        return "index";
    }
    @GetMapping(value = "/mda")
    public String mda() {
        return "single-videos";
    }

    @GetMapping(value = "/kek")
    public String mmm() {
        return "index";
    }
}
