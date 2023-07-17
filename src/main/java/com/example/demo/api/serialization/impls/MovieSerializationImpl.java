package com.example.demo.api.serialization.impls;

import com.example.demo.api.serialization.MovieSerialization;
import com.example.demo.api.serialization.MovieSnippetSerialization;
import com.example.demo.api.serialization.MovieStatisticsSerialization;
import com.example.demo.api.serialization.MovieThumbnailsSerialization;
import com.example.demo.entities.impls.Cast;
import com.example.demo.entities.impls.Genres;
import com.example.demo.entities.impls.Movie;
import com.example.demo.respository.CastRepository;
import com.example.demo.respository.GenresRepository;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class MovieSerializationImpl implements MovieSerialization {
    private final GenresRepository genresRepository;
    private final CastRepository castRepository;
    private final MovieThumbnailsSerialization movieThumbnailsSerialization;
    private final MovieStatisticsSerialization movieStatisticsSerialization;
    private final MovieSnippetSerialization movieSnippetSerialization;
    @Override
    public Movie importMovieToDataBase(JsonNode jsonNode, List<Long> genresId, List<Long> castsId, LocalTime runTime, Date releaseDate, double rating) {
        if (jsonNode != null &&
                !castsId.isEmpty() && !genresId.isEmpty() &&
                runTime != null && releaseDate != null
                && rating != 0) {
            Movie movie = new Movie();
            movie.setMovieId(jsonNode.get("id").asText());
            List<Genres> genresList = new ArrayList<>();
            for (Long id : genresId) {
                Genres genres = genresRepository.findById(id).orElse(
                        new Genres("Comedy"));
                genresList.add(genres);
            }
            List<Cast> castList = new ArrayList<>();
            for(Long id : castsId) {
                Cast cast = castRepository.findById(id).orElse(new Cast(
                        "Tom Holland", "Tom", "Holland"));
                castList.add(cast);
            }
            movie.setCast(castList);
            movie.setGenres(genresList);
            movie.setMovieSnippet(movieSnippetSerialization.
                    importMovieSnippetToDataBase(jsonNode, runTime, releaseDate, rating));
            movie.setMovieStatistics(movieStatisticsSerialization.
                    importMovieStatisticsToDataBase(jsonNode));
            movie.setThumbnails(movieThumbnailsSerialization.
                    importThumbnailsToDataBase(jsonNode));
            return movie;
        } else {
            return null;
        }
    }

    @Override
    public Movie updateMovie(String movieId, Map<String, Object> request, Optional<Movie> optionalMovie) {
        if(optionalMovie.isPresent()) {
            Movie currentMovie = optionalMovie.get();
            if (request.containsKey("movieTitle")) {
                currentMovie.getMovieSnippet().setTitle((String) request.get("movieTitle"));
            }
            if (request.containsKey("movieDescription")) {
                currentMovie.getMovieSnippet().setDescription((String) request.get("movieDescription"));
            }
            if (request.containsKey("movieViewsCount")) {
                String viewsCountStr = (String) request.get("movieViewsCount");
                Integer viewsCount = Integer.valueOf(viewsCountStr);
                currentMovie.getMovieStatistics().setViewsCount(viewsCount.longValue());
            }
            if (request.containsKey("movieLikesCount")) {
                String likesCountStr = (String) request.get("movieLikesCount");
                Integer likesCount = Integer.valueOf(likesCountStr);
                currentMovie.getMovieStatistics().setLikesCount(likesCount.longValue());
            }
            return currentMovie;
        } else {
            return null;
        }
    }
}
