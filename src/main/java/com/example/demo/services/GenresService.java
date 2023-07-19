package com.example.demo.services;

import com.example.demo.dto.GenresDTO;

import java.util.List;

public interface GenresService {
    List<GenresDTO> findAll();
}
