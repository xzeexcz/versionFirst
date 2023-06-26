package com.example.demo.restControllers;

import com.example.demo.entities.impls.MovieStatistics;
import com.example.demo.respository.MovieSnippetRepository;
import com.example.demo.services.*;
import com.example.demo.api.YoutubeAPIClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.GeneralSecurityException;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/home")
public class VideoController {

    private final YoutubeAPIClient youtubeAPIClient;
    private final MovieSnippetRepository movieSnippetRepository;
    private final MovieService movieService;
    private final MovieSnippetService movieSnippetService;
    private final MovieStatisticsService movieStatisticsService;
    private final ThumbnailsService thumbnailsService;
    private final ThumbnailService thumbnailService;


    @GetMapping(value = "/{videoId}")
    public void getVideos(@PathVariable String videoId) throws GeneralSecurityException, IOException {
        movieService.home(videoId);
    }
}
