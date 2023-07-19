package com.example.demo.services;

import com.example.demo.dto.videos.VideoDTO;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface VideoService {
    void addVideoToDataBase(String videoId,
                            LocalTime runTime, Date releaseDate,
                            double rating) throws GeneralSecurityException, IOException;
    List<VideoDTO> getVideosFromDataBase();
    VideoDTO getOneMovieFromDataBase(String url);

    VideoDTO updateVideo(String url , Map<String, Object> request);

    void deleteVideoFromDataBase(String url);
}
