package com.example.demo.restControllers;

import com.example.demo.dto.MovieDTO;
import com.example.demo.entities.impls.Movie;
import com.example.demo.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/home")
public class MovieController {

    private final MovieService movieService;
    @PostMapping(value = "/add-movie/{videoId}")
    public void addMovieToDataBase(@PathVariable String videoId,
                          @RequestParam(name = "genresId") List<Long> genresId,
                          @RequestParam(name = "castsId") List<Long> castsId,
                          @RequestParam(name = "runtime")
                              @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX") Date runTime,
                          @RequestParam(name = "releaseDate")
                              @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX") Date releaseDate,
                          @RequestParam(name = "rating") double rating) throws GeneralSecurityException, IOException {
        movieService.addMovieToDataBase(videoId,genresId,castsId,runTime,releaseDate,rating);
    }
    @GetMapping()
    public List<Movie> getAllMoviesFromDataBase() {
        return movieService.getMoviesFromDataBase();
    }
    @GetMapping(value = "/movie/{videoId}")
    public Movie getOneMovie(@PathVariable String videoId) {
        return movieService.getOneMovieFromDataBase(videoId);
    }
    @GetMapping(value = "/dto/{videoId}")
    public MovieDTO getOneMovieDto(@PathVariable String videoId) {
    return movieService.getOneMovieDtoFromDataBase(videoId);
    }
    @GetMapping(value = "/dto")
    public List<MovieDTO> getMoviesDtoFromDataBase() {
        return movieService.getMoviesDtoFromDataBase();
    }
}
