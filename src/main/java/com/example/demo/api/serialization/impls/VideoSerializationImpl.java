package com.example.demo.api.serialization.impls;

import com.example.demo.api.serialization.VideoSerialization;
import com.example.demo.api.serialization.VideoSnippetSerialization;
import com.example.demo.api.serialization.VideoStatisticsSerialization;
import com.example.demo.api.serialization.VideoThumbnailsSerialization;
import com.example.demo.entities.impls.Video;
import com.example.demo.entities.impls.VideoStatistics;
import com.example.demo.entities.impls.VideoType;
import com.example.demo.respository.videos.VideoTypeRepository;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class VideoSerializationImpl implements VideoSerialization {

    private final VideoTypeRepository videoTypeRepository;
    private final VideoSnippetSerialization videoSnippetSerialization;
    private final VideoStatisticsSerialization videoStatisticsSerialization;
    private final VideoThumbnailsSerialization videoThumbnailsSerialization;
    @Override
    public Video importVideoToDataBase(JsonNode jsonNode, LocalTime runTime, Date releaseDate, double rating, Long videoType) {
        if(jsonNode == null) {
            return null;
        }
        if(runTime != null || releaseDate !=null || rating != 0.0 || videoType != 0) {
            Video video = new Video();
            video.setUrl(jsonNode.get("id").asText());
            VideoType type = videoTypeRepository.findById(videoType).orElse(null);
            if(type !=null) {
                video.setVideoType(type);
            }
            if(videoSnippetSerialization.importVideoSnippetToDataBase(jsonNode, runTime, releaseDate, rating) != null) {
                video.setVideoSnippet(
                        videoSnippetSerialization.importVideoSnippetToDataBase(jsonNode, runTime, releaseDate, rating));
            }
            if(videoStatisticsSerialization.importVideoStatisticsToDataBase(jsonNode) != null) {
                video.setVideoStatistics(
                        videoStatisticsSerialization.importVideoStatisticsToDataBase(jsonNode));
            }
            if(videoThumbnailsSerialization.importVideoThumbnailsToDataBase(jsonNode) != null) {
                video.setVideoThumbnails(
                        videoThumbnailsSerialization.importVideoThumbnailsToDataBase(jsonNode));
            }
            return video;
        } else {
            return null;
        }
    }
}
