package com.example.demo.mapper;

import com.example.demo.dto.GenresDTO;
import com.example.demo.entities.impls.Genres;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {MovieSnippetMapper.class, MovieStatisticsMapper.class,
        ThumbnailsMapper.class, CastMapper.class, GenresMapper.class})
public interface GenresMapper {
    GenresMapper INSTANCE = Mappers.getMapper(GenresMapper.class);
    GenresDTO toGenresDto(Genres genres);
    Genres toGenresEntity(GenresDTO genresDTO);
    List<GenresDTO> toGenresDtoList(List<Genres> genresList);
    List<Genres> toGenresEntityList(List<GenresDTO> genresDTOList);
}
