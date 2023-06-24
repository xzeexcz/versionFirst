package com.example.demo.services;

import com.example.demo.respository.ThumbnailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ThumbnailService {
    private final ThumbnailRepository thumbnailRepository;
}
