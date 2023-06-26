package com.example.demo.entities.impls;

import com.example.demo.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_movies_snippet")
@Getter
@Setter
public class MovieSnippet extends BaseEntity {

    @Column(name = "m_snippet_defaultAudioLang")
    private String defaultAudioLanguage;
    @Column(name = "m_snippet_defaultLang")
    private String defaultLanguage;
    @Column(name = "m_snippet_description",columnDefinition = "TEXT")
    private String description;
    @Column(name = "m_snippet_title")
    private String title;

}
