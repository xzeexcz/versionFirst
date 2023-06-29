package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MovieSnippetDTO {
    private String defaultAudioLanguage;
    private String defaultLanguage;
    private String description;
    private String title;
    private Date releaseDate;
    private Date runTime;
    private double rating;
}
