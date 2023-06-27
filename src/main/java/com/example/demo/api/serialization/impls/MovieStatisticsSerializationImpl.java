package com.example.demo.api.serialization.impls;

import com.example.demo.api.serialization.MovieStatisticsSerialization;
import com.example.demo.entities.impls.MovieStatistics;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieStatisticsSerializationImpl implements MovieStatisticsSerialization {
    @Override
    public MovieStatistics importMovieStatisticsToDataBase(JsonNode jsonNode) {
        if (jsonNode != null) {
            MovieStatistics movieStatistics = new MovieStatistics();
            if (jsonNode.get("statistics").get("likeCount").asLong() == 0) {
                movieStatistics.setLikesCount(20312L);
            } else {
                movieStatistics.setLikesCount(
                        jsonNode.get("statistics").get("likeCount").asLong());
            }
            if (jsonNode.get("statistics").get("viewCount").asLong() == 0) {
                movieStatistics.setViewsCount(221321L);
            } else {
                movieStatistics.setViewsCount(jsonNode.get("statistics").get("viewCount").asLong());
            }
            return movieStatistics;
        }   else {
            return null;
        }
    }
}
