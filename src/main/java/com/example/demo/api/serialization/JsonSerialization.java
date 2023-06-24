package com.example.demo.api.serialization;

import com.example.demo.entities.impls.*;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;

@Service
public class JsonSerialization {
    public final MovieSnippet importMovieSnippetToDataBase(JsonNode jsonNode) {
        if(jsonNode!=null) {
            MovieSnippet movieSnippet = new MovieSnippet();
            if (jsonNode.get("snippet").get("defaultAudioLanguage").asText() == null) {
                movieSnippet.setDefaultAudioLanguage("en");
            } else {
                movieSnippet.setDefaultAudioLanguage(
                        jsonNode.get("snippet").get("defaultAudioLanguage").asText());
            }
            if (jsonNode.get("snippet").get("defaultLanguage").isEmpty()) {
                movieSnippet.setDefaultLanguage("en");
            } else {
                movieSnippet.setDefaultLanguage(
                        jsonNode.get("snippet").get("defaultLanguage").asText());
            }
            if (jsonNode.get("snippet").get("description").asText() == null) {
                movieSnippet.setDescription("Some description there...");
            } else {
                movieSnippet.setDescription(
                        jsonNode.get("snippet").get("description").asText());
            }
            if (jsonNode.get("snippet").get("title").asText() == null) {
                movieSnippet.setTitle("Some title right there...");
            } else {
                movieSnippet.setTitle(
                        jsonNode.get("snippet").get("title").asText());
            }
            movieSnippet.setMovie(new Movie(jsonNode.get("id").asText()));
            return movieSnippet;
        } else {
            return null;
        }
    }
    public final Movie importMovieToDataBase(JsonNode jsonNode) {
        if (jsonNode != null) {
            Movie movie = new Movie();
            movie.setMovieId(jsonNode.get("id").asText());
            return movie;
        } else {
            return null;
        }
    }
    public final MovieStatistics importMovieStatisticsToDataBase(JsonNode jsonNode) {
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
            movieStatistics.setMovie(new Movie(jsonNode.get("id").asText()));
            return movieStatistics;
        }   else {
            return null;
        }
    }
//    public final Thumbnail importThumbnailToDataBase(JsonNode jsonNode) {
//        if(jsonNode!=null) {
//            if(jsonNode.get("snippet").get("thumbnails")!=null) {
//                Thumbnail thumbnail = new Thumbnail();
//                return thumbnail;
//            } else {
//                return null;
//            }
//        } else {
//            return null;
//        }
//    }
    public final Thumbnails importThumbnailsToDataBase(JsonNode jsonNode) {
        if(jsonNode!=null) {
            Thumbnails thumbnails = new Thumbnails();
            if(jsonNode.get("snippet").get("thumbnails")!=null) {
                thumbnails.setMovie(new Movie(jsonNode.get("id").asText()));
                thumbnails.setDefaultThumbnail(new Thumbnail(
                        jsonNode.get("snippet").get("thumbnails").get("default").get("height").asInt(),
                        jsonNode.get("snippet").get("thumbnails").get("default").get("url").asText(),
                        jsonNode.get("snippet").get("thumbnails").get("default").get("width").asInt()));
                thumbnails.setHighThumbnail(new Thumbnail(
                        jsonNode.get("snippet").get("thumbnails").get("high").get("height").asInt(),
                        jsonNode.get("snippet").get("thumbnails").get("high").get("url").asText(),
                        jsonNode.get("snippet").get("thumbnails").get("high").get("width").asInt()));
                thumbnails.setMaxresThumbnail(new Thumbnail(
                        jsonNode.get("snippet").get("thumbnails").get("maxres").get("height").asInt(),
                        jsonNode.get("snippet").get("thumbnails").get("maxres").get("url").asText(),
                        jsonNode.get("snippet").get("thumbnails").get("maxres").get("width").asInt()));
                thumbnails.setMediumThumbnail(new Thumbnail(
                        jsonNode.get("snippet").get("thumbnails").get("medium").get("height").asInt(),
                        jsonNode.get("snippet").get("thumbnails").get("medium").get("url").asText(),
                        jsonNode.get("snippet").get("thumbnails").get("medium").get("width").asInt()));
                thumbnails.setStandardThumbnail(new Thumbnail(
                        jsonNode.get("snippet").get("thumbnails").get("standard").get("height").asInt(),
                        jsonNode.get("snippet").get("thumbnails").get("standard").get("url").asText(),
                        jsonNode.get("snippet").get("thumbnails").get("standard").get("width").asInt()));
                return thumbnails;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}
