package com.example.demo.services;

import com.example.demo.entities.impls.FavoriteMovies;

import java.util.List;

public interface FavoriteMoviesService {
    List<FavoriteMovies> getAllFavoriteMoviesByUser(Long id);
}
