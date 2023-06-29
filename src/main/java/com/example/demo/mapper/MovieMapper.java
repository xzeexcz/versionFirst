package com.example.demo.mapper;

import com.example.demo.dto.MovieDTO;
import com.example.demo.dto.MovieSnippetDTO;
import com.example.demo.entities.impls.Movie;
import com.example.demo.entities.impls.MovieSnippet;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.SubclassMapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {MovieSnippetMapper.class, MovieStatisticsMapper.class,
        ThumbnailsMapper.class, CastMapper.class, GenresMapper.class})
public interface MovieMapper {
    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);
    @Mapping(source = "movieSnippet", target = "movieSnippetDTO")
    @Mapping(source = "movieStatistics", target = "movieStatisticsDTO")
    @Mapping(source = "thumbnails", target = "thumbnailsDTO")
    @Mapping(source = "cast", target = "castDTOList")
    @Mapping(source = "genres", target = "genresDTOList")
    MovieDTO toMovieDto(Movie movie);
    @Mapping(source = "movieSnippetDTO", target = "movieSnippet")
    @Mapping(source = "movieStatisticsDTO", target = "movieStatistics")
    @Mapping(source = "thumbnailsDTO", target = "thumbnails")
    @Mapping(source = "castDTOList", target = "cast")
    @Mapping(source = "genresDTOList", target = "genres")
    Movie toMovieEntity(MovieDTO movieDTO);
    List<MovieDTO> toMovieDtoList(List<Movie> movieList);
    List<Movie> toMovieEntityList(List<MovieDTO> movieDTOList);
}