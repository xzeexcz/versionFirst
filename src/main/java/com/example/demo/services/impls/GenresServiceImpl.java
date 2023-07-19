package com.example.demo.services.impls;

import com.example.demo.dto.GenresDTO;
import com.example.demo.mapper.GenresMapper;
import com.example.demo.respository.GenresRepository;
import com.example.demo.services.GenresService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenresServiceImpl implements GenresService {
    private final GenresRepository genresRepository;
    private final GenresMapper genresMapper;
    @Override
    public List<GenresDTO> findAll() {
        return genresMapper.toGenresDtoList(genresRepository.findAll());
    }
}
