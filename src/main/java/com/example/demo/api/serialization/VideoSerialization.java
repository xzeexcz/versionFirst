package com.example.demo.api.serialization;

import com.example.demo.entities.impls.Video;
import com.fasterxml.jackson.databind.JsonNode;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface VideoSerialization {
    Video importVideoToDataBase(JsonNode jsonNode,
                                LocalTime runTime,
                                Date releaseDate,
                                double rating);
    Video updateMovie(String url, Map<String, Object> request, Optional<Video> optionalVideo);
}
