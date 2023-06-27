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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieSerializationImpl implements MovieSerialization {
    private final GenresRepository genresRepository;
    private final CastRepository castRepository;
    private final MovieThumbnailsSerialization movieThumbnailsSerialization;
    private final MovieStatisticsSerialization movieStatisticsSerialization;
    private final MovieSnippetSerialization movieSnippetSerialization;
    @Override
    public Movie importMovieToDataBase(JsonNode jsonNode, List<Long> genresId, List<Long> castsId, Date runTime, Date releaseDate, double rating) {
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
}
