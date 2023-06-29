package com.example.demo.dto;

import com.example.demo.entities.impls.Thumbnail;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ThumbnailsDTO {
    private ThumbnailDTO defaultThumbnail;
    private ThumbnailDTO highThumbnail;
    private ThumbnailDTO maxresThumbnail;
    private ThumbnailDTO mediumThumbnail;
    private ThumbnailDTO standardThumbnail;
}
