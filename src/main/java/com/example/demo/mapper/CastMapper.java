package com.example.demo.mapper;

import com.example.demo.dto.CastDTO;
import com.example.demo.entities.impls.Cast;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {MovieSnippetMapper.class, MovieStatisticsMapper.class,
        ThumbnailsMapper.class, CastMapper.class, GenresMapper.class})
public interface CastMapper {
    CastMapper INSTANCE = Mappers.getMapper(CastMapper.class);
    CastDTO toCastDto(Cast cast);
    Cast toCastEntity(CastDTO castDTO);
    List<CastDTO> toCastDtoList(List<Cast> castsList);
    List<Cast> toCastEntityList(List<CastDTO> castDTOList);
}
