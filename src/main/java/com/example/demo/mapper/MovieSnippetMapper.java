package com.example.demo.mapper;

import com.example.demo.dto.MovieSnippetDTO;
import com.example.demo.entities.impls.MovieSnippet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring" , uses = {MovieSnippetMapper.class, MovieStatisticsMapper.class,
        ThumbnailsMapper.class, CastMapper.class, GenresMapper.class})
public interface MovieSnippetMapper {

    MovieSnippetMapper INSTANCE = Mappers.getMapper(MovieSnippetMapper.class);

    MovieSnippetDTO toMovieSnippetDto(MovieSnippet movieSnippet);
    MovieSnippet toMovieSnippetEntity(MovieSnippetDTO movieSnippetDTO);
    List<MovieSnippetDTO> toMovieSnippetDtoList(List<MovieSnippet> movieSnippetList);
    List<MovieSnippet> toMovieSnippetEntityList(List<MovieSnippetDTO> movieSnippetDTOS);

}
