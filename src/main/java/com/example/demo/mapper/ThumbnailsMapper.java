package com.example.demo.mapper;

import com.example.demo.dto.ThumbnailDTO;
import com.example.demo.dto.ThumbnailsDTO;
import com.example.demo.entities.impls.Thumbnails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {MovieSnippetMapper.class, MovieStatisticsMapper.class,
        ThumbnailsMapper.class, GenresMapper.class})
public interface ThumbnailsMapper {
    ThumbnailsMapper INSTANCE = Mappers.getMapper(ThumbnailsMapper.class);
    ThumbnailsDTO toThumbnailsDto(Thumbnails thumbnails);
    Thumbnails toThumbnailsEntity(ThumbnailsDTO thumbnailsDTO);
    List<ThumbnailDTO> toThumbnailsDtoList(List<Thumbnails> thumbnailsList);
    List<Thumbnails> toThumbnailsEntityList(List<ThumbnailsDTO> thumbnailsDTOList);
}
