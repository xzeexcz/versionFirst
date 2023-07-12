package com.example.demo.services.impls;

import com.example.demo.api.serialization.VideoStatisticsSerialization;
import com.example.demo.services.VideoStatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VideoStatisticsServiceImpl implements VideoStatisticsService {
    private final VideoStatisticsSerialization videoStatisticsSerialization;
}
