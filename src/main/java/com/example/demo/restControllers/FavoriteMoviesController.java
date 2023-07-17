package com.example.demo.restControllers;

import com.example.demo.entities.impls.FavoriteMovies;
import com.example.demo.services.FavoriteMoviesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/favourites")
@RequiredArgsConstructor
public class FavoriteMoviesController {
    private final FavoriteMoviesService favoriteMoviesService;
    @GetMapping()
    public List<FavoriteMovies> findAllFavourites(@RequestParam(name = "user_id", defaultValue = "1") Long user_id) {
        return favoriteMoviesService.getAllFavoriteMoviesByUser(user_id);
    }
}
