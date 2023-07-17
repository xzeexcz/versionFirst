package com.example.demo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class FavouriteMovieController {
    @GetMapping(value = "/favourites/page")
    public String favouriteMovies() {
        return "movies-favourite";
    }
}
