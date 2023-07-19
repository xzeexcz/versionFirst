package com.example.demo.mapper.videos;

import com.example.demo.dto.videos.VideoStatisticsDTO;
import com.example.demo.entities.impls.VideoStatistics;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {VideoStatisticsMapper.class, VideoStatisticsMapper.class,
        VideoThumbnailMapper.class, VideoThumbnailsMapper.class})
public interface VideoStatisticsMapper {
    VideoStatisticsMapper INSTANCE = Mappers.getMapper(VideoStatisticsMapper.class);

    VideoStatisticsDTO toVideoStatisticsDto(VideoStatistics videoStatistics);
    VideoStatistics toVideoStatisticsEntity(VideoStatisticsDTO videoStatisticsDTO);
}
