package com.example.demo.api.serialization;

import com.example.demo.entities.impls.Video;
import com.fasterxml.jackson.databind.JsonNode;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public interface VideoSerialization {
    Video importVideoToDataBase(JsonNode jsonNode,
                                LocalTime runTime,
                                Date releaseDate,
                                double rating,
                                Long videoType);
}
