package com.example.demo.services;

import com.example.demo.api.YoutubeAPIClient;
import com.example.demo.api.serialization.JsonSerialization;
import com.example.demo.respository.MovieSnippetRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.services.youtube.model.Video;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;

@Service
@RequiredArgsConstructor
public class MovieSnippetService {
    private final MovieSnippetRepository movieSnippetRepository;
    private final YoutubeAPIClient youtubeAPIClient;
    private final JsonSerialization jsonSerialization;
    public final void home(String videoId) throws GeneralSecurityException, IOException {
        Video video = youtubeAPIClient.getVideoDetails(videoId);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.valueToTree(video);
        if(jsonNode!=null) {
            movieSnippetRepository.save(
                    jsonSerialization.importMovieSnippetToDataBase(jsonNode));
        } else  {
            throw new IOException();
        }
    }
}
