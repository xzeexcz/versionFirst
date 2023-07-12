package com.example.demo.api.serialization;

import com.example.demo.entities.impls.VideoThumbnails;
import com.fasterxml.jackson.databind.JsonNode;

public interface VideoThumbnailsSerialization {
    VideoThumbnails importVideoThumbnailsToDataBase(JsonNode jsonNode);
}
