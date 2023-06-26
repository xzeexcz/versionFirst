package com.example.demo.entities.impls;

import com.example.demo.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "t_movies")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Movie extends BaseEntity {

    @Column(name = "movies_id")
    private String movieId;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_snippet_id")
    private MovieSnippet movieSnippet;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_statistics_id")
    private MovieStatistics movieStatistics;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_thumbnails_id")
    private Thumbnails thumbnails;

}
