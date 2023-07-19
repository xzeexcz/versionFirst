package com.example.demo.services;

import com.example.demo.dto.MovieDTO;
import com.example.demo.entities.impls.Movie;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface MovieService {

    void addMovieToDataBase(String videoId,
                            List<Long> genresId,
                            LocalTime runTime, Date releaseDate,
                            double rating) throws GeneralSecurityException, IOException;

    List<Movie> getMoviesFromDataBase();

    Movie getOneMovieFromDataBase(String videoId);

    MovieDTO getOneMovieDtoFromDataBase(String videoId);
    List<MovieDTO> getMoviesDtoFromDataBase();

    void deleteMoviesFromDataBase(String url);


    MovieDTO updateMovie(String movieId, Map<String, Object> request);

//    MovieDTO editMovie(Long id);
}
