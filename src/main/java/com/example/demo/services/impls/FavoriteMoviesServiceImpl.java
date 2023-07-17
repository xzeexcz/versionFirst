package com.example.demo.services.impls;

import com.example.demo.entities.impls.FavoriteMovies;
import com.example.demo.respository.FavoriteMoviesRepository;
import com.example.demo.services.FavoriteMoviesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FavoriteMoviesServiceImpl implements FavoriteMoviesService {
    private final FavoriteMoviesRepository favoriteMoviesRepository;

    @Override
    public List<FavoriteMovies> getAllFavoriteMoviesByUser(Long id) {
        List<FavoriteMovies> favoriteMovies = favoriteMoviesRepository.findAllByUser_Id(id);
        System.out.println(favoriteMovies);
        return favoriteMovies;
    }
}
