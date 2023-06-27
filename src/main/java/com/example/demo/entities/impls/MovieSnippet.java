package com.example.demo.entities.impls;

import com.example.demo.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "t_movies_snippet")
@Getter
@Setter
public class MovieSnippet extends BaseEntity {

    @Column(name = "m_snippet_defaultAudioLang", length = 20)
    private String defaultAudioLanguage;
    @Column(name = "m_snippet_defaultLang", length = 20)
    private String defaultLanguage;
    @Column(name = "m_snippet_description",columnDefinition = "TEXT")
    private String description;
    @Column(name = "m_snippet_title", length = 200)
    private String title;
    @Column(name = "m_snippet_release_date")
    private Date releaseDate;
    @Column(name = "m_snippet_runtime")
    private Date runTime;
    @Column(name = "m_snippet_rating", length = 20, columnDefinition = "DOUBLE")
    private double rating;

}
