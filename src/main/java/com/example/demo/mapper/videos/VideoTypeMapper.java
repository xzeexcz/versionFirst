package com.example.demo.mapper.videos;

import com.example.demo.dto.videos.VideoTypeDTO;
import com.example.demo.entities.impls.VideoType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {VideoStatisticsMapper.class, VideoStatisticsMapper.class,
        VideoThumbnailMapper.class, VideoThumbnailsMapper.class, VideoTypeMapper.class})
public interface VideoTypeMapper {
    VideoTypeMapper INSTANCE = Mappers.getMapper(VideoTypeMapper.class);

    @Mapping(source = "videoTypeName", target = "videoType")
    VideoTypeDTO toVideoTypeDto(VideoType videoType);

    @Mapping(source = "videoType", target = "videoTypeName")
    VideoType toVideoTypeEntity(VideoTypeDTO videoTypeDTO);
}
