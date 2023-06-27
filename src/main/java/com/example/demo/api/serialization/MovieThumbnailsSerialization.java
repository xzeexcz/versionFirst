package com.example.demo.api.serialization;

import com.example.demo.entities.impls.Thumbnails;
import com.fasterxml.jackson.databind.JsonNode;

public interface MovieThumbnailsSerialization {
    Thumbnails importThumbnailsToDataBase(JsonNode jsonNode);
}
