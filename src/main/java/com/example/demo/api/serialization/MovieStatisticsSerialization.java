package com.example.demo.api.serialization;

import com.example.demo.entities.impls.MovieStatistics;
import com.fasterxml.jackson.databind.JsonNode;

public interface MovieStatisticsSerialization {
    MovieStatistics importMovieStatisticsToDataBase(JsonNode jsonNode);
}
