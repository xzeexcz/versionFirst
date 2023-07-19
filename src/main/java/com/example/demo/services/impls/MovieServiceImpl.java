package com.example.demo.services.impls;

import com.example.demo.api.YoutubeAPIClient;
import com.example.demo.api.serialization.MovieSerialization;
import com.example.demo.dto.MovieDTO;
import com.example.demo.entities.impls.Movie;
import com.example.demo.mapper.MovieMapper;
import com.example.demo.respository.MovieRepository;
import com.example.demo.services.MovieService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.services.youtube.model.Video;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.LocalTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final YoutubeAPIClient youtubeAPIClient;
    private final MovieRepository movieRepository;
    private final MovieSerialization movieSerialization;
    private final MovieMapper movieMapper;

    @Override
    public void addMovieToDataBase(String videoId,
                                   List<Long> genresId,
                                   LocalTime runTime, Date releaseDate,
                                   double rating) throws GeneralSecurityException, IOException {
        Video video = youtubeAPIClient.getVideoDetails(videoId);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.valueToTree(video);
        if(jsonNode!=null) {
            movieRepository.save(movieSerialization.importMovieToDataBase(jsonNode,
                    genresId,runTime,releaseDate,rating));
        } else  {
            throw new IOException();
        }
    }

    @Override
    public List<Movie> getMoviesFromDataBase() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getOneMovieFromDataBase(String videoId) {
        return movieRepository.findByMovieId(videoId);
    }

    @Override
    public MovieDTO getOneMovieDtoFromDataBase(String videoId) {
        return movieMapper.toMovieDto(movieRepository.findByMovieId(videoId));
    }

    @Override
    public List<MovieDTO> getMoviesDtoFromDataBase() {
        return movieMapper.toMovieDtoList(movieRepository.findAll());
    }

    @Override
    public void deleteMoviesFromDataBase(String url) {
            Movie movie = movieRepository.findByMovieId(url);
            if(movie !=null) {
                movieRepository.delete(movie);
            }
    }

    @Override
    public MovieDTO updateMovie(String movieId, Map<String, Object> request) {
        Optional<Movie> optionalMovie = Optional.ofNullable(movieRepository.findByMovieId(movieId));

        Movie movie = movieSerialization.updateMovie(movieId,request,optionalMovie);
        if(movie != null) {
            return movieMapper.toMovieDto(movieRepository.save(movie));
        } else {
            return null;
        }
    }
}
