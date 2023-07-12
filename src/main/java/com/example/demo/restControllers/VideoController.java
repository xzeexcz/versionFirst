package com.example.demo.restControllers;

import com.example.demo.dto.videos.VideoDTO;
import com.example.demo.services.UserService;
import com.example.demo.services.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.LocalTime;
import java.util.Date;

@RestController
@RequestMapping(value = "/videos")
@RequiredArgsConstructor
public class VideoController {
    private final VideoService videoService;

    @PostMapping(value = "/add-video/{videoId}")
    public void addVideoToDataBase(@PathVariable String videoId,
                                   @RequestParam(name = "runTime")
                                   @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX") LocalTime runTime,
                                   @RequestParam(name = "releaseDate")
                                       @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX") Date releaseDate,
                                   @RequestParam(name = "rating") double rating,
                                   @RequestParam(name = "videoType") Long videoType)
                                            throws GeneralSecurityException, IOException {
        videoService.addVideoToDataBase(videoId,runTime,releaseDate,rating,videoType);
    }

    @GetMapping(value = "/{id}")
    public VideoDTO getOneVideoByUrl(@PathVariable String id) {
        return videoService.getOneMovieFromDataBase(id);
    }
}
