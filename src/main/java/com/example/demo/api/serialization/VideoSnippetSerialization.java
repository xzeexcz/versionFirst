package com.example.demo.api.serialization;

import com.example.demo.entities.impls.VideoSnippet;
import com.fasterxml.jackson.databind.JsonNode;

import java.time.LocalTime;
import java.util.Date;

public interface VideoSnippetSerialization {
    VideoSnippet importVideoSnippetToDataBase(JsonNode jsonNode,
                                              LocalTime runTime, Date releaseDate,
                                              double rating);
}
