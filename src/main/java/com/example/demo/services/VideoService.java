package com.example.demo.services;

import com.example.demo.dto.videos.VideoDTO;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public interface VideoService {
    void addVideoToDataBase(String videoId,
                            LocalTime runTime, Date releaseDate,
                            double rating, Long videoType) throws GeneralSecurityException, IOException;
    List<VideoDTO> getVideosFromDataBase();
    VideoDTO getOneMovieFromDataBase(String url);

//    void deleteVideoFromDataBase(Long[] id);
}
