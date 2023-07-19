package com.example.demo.services.impls;

import com.example.demo.api.YoutubeAPIClient;
import com.example.demo.api.serialization.VideoSerialization;
import com.example.demo.dto.videos.VideoDTO;
import com.example.demo.mapper.videos.VideoMapper;
import com.example.demo.respository.videos.VideoRepository;
import com.example.demo.services.VideoService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.services.youtube.model.Video;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VideoServiceImpl implements VideoService {
    private final VideoSerialization videoSerialization;
    private final VideoRepository videoRepository;
    private final YoutubeAPIClient youtubeAPIClient;
    private final VideoMapper videoMapper;
    @Override
    public void addVideoToDataBase(String videoId, LocalTime runTime, Date releaseDate, double rating)
            throws GeneralSecurityException, IOException {
        Video video = youtubeAPIClient.getVideoDetails(videoId);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.valueToTree(video);
        if(jsonNode !=null) {
            videoRepository.save(
                    videoSerialization.importVideoToDataBase(jsonNode,runTime,releaseDate,rating));
        } else {
            throw new IOException();
        }
    }

    @Override
    public List<VideoDTO> getVideosFromDataBase() {
        return videoMapper.toVideoDTOList(videoRepository.findAll());
    }

    @Override
    public VideoDTO getOneMovieFromDataBase(String videoId) {
        return videoMapper.toVideoDto(videoRepository.getVideoByUrl(videoId));
    }

    @Override
    public VideoDTO updateVideo(String url, Map<String, Object> request) {
        Optional<com.example.demo.entities.impls.Video> optionalVideo = Optional.ofNullable
                (videoRepository.getVideoByUrl(url));
        com.example.demo.entities.impls.Video video = videoSerialization.updateMovie(url,request,optionalVideo);
        if(video!=null) {
            return videoMapper.toVideoDto(videoRepository.save(video));
        } else {
            return null;
        }
    }

    @Override
    public void deleteVideoFromDataBase(String url) {
        com.example.demo.entities.impls.Video video = videoRepository.getVideoByUrl(url);
        if(video!=null) {
            videoRepository.delete(video);
        }
    }
}
