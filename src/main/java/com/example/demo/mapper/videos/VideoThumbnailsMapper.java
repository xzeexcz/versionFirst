package com.example.demo.mapper.videos;

import com.example.demo.dto.videos.VideoThumbnailsDTO;
import com.example.demo.entities.impls.VideoThumbnails;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {VideoStatisticsMapper.class, VideoStatisticsMapper.class,
        VideoThumbnailMapper.class, VideoThumbnailsMapper.class})
public interface VideoThumbnailsMapper {
    VideoThumbnailsMapper INSTANCE = Mappers.getMapper(VideoThumbnailsMapper.class);
    VideoThumbnailsDTO toVideoThumbnailsDto(VideoThumbnails videoThumbnails);
    VideoThumbnails toVideoThumbnailsEntity(VideoThumbnailsDTO videoThumbnailsDTO);
}
