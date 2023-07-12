package com.example.demo.dto.videos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VideoThumbnailsDTO {
    private VideoThumbnailDTO defaultThumbnail;
    private VideoThumbnailDTO high;
    private VideoThumbnailDTO maxresThumbnail;
    private VideoThumbnailDTO mediumThumbnail;
    private VideoThumbnailDTO standardThumbnail;
}
