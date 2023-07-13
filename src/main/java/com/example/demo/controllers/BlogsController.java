package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class BlogsController {
    @GetMapping(value = "/blogs")
    public String blogs() {
        return "blogs";
    }
    @GetMapping(value = "/blogs/{id}")
    public String blogDetails(@RequestParam Long id) {
        return "blog-single";
    }
    @GetMapping(value = "/blofds")
    public String blogDetails2() {
        return "blog-single";
    }
}
