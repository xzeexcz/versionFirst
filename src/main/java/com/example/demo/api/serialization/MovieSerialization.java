package com.example.demo.api.serialization;

import com.example.demo.entities.impls.Movie;
import com.fasterxml.jackson.databind.JsonNode;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public interface MovieSerialization {
    Movie importMovieToDataBase(JsonNode jsonNode, List<Long> genresId,
                                List<Long> castsId,
                                LocalTime runTime,
                                Date releaseDate,
                                double rating);
}
