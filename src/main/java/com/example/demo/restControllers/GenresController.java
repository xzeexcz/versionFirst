package com.example.demo.restControllers;

import com.example.demo.dto.GenresDTO;
import com.example.demo.respository.GenresRepository;
import com.example.demo.services.GenresService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/genres")
@RequiredArgsConstructor
public class GenresController {
    private final GenresService genresService;

    @GetMapping
    public List<GenresDTO> findAllGenres() {
        return genresService.findAll();
    }
}
