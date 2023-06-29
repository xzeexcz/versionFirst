package com.example.demo.services;

import com.example.demo.dto.MovieDTO;
import com.example.demo.entities.impls.Movie;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.List;

public interface MovieService {

    void addMovieToDataBase(String videoId,
                           List<Long> genresId, List<Long> castsId,
                           Date runTime, Date releaseDate,
                           double rating) throws GeneralSecurityException, IOException;

    List<Movie> getMoviesFromDataBase();

    Movie getOneMovieFromDataBase(String videoId);

    MovieDTO getOneMovieDtoFromDataBase(String videoId);
    List<MovieDTO> getMoviesDtoFromDataBase();
}
