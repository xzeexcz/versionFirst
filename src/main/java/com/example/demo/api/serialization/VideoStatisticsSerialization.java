package com.example.demo.api.serialization;

import com.example.demo.entities.impls.VideoStatistics;
import com.fasterxml.jackson.databind.JsonNode;


public interface VideoStatisticsSerialization {
    VideoStatistics importVideoStatisticsToDataBase(JsonNode jsonNode);
}
