package com.example.demo.mapper.videos;

import com.example.demo.dto.videos.VideoSnippetDTO;
import com.example.demo.entities.impls.VideoSnippet;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {VideoStatisticsMapper.class, VideoStatisticsMapper.class,
        VideoThumbnailMapper.class, VideoThumbnailsMapper.class})
public interface VideoSnippetMapper {
    VideoSnippetMapper INSTANCE = Mappers.getMapper(VideoSnippetMapper.class);

    VideoSnippetDTO toVideoSnippetDto(VideoSnippet videoSnippet);
    VideoSnippet toVideoSnippetEntity(VideoSnippetDTO videoSnippetDTO);


}
