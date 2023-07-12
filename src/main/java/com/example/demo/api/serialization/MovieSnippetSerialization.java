package com.example.demo.api.serialization;

import com.example.demo.entities.impls.MovieSnippet;
import com.fasterxml.jackson.databind.JsonNode;

import java.time.LocalTime;
import java.util.Date;

public interface MovieSnippetSerialization {
    MovieSnippet importMovieSnippetToDataBase(JsonNode jsonNode,
                                              LocalTime runTime, Date releaseDate,
                                              double rating);
}
