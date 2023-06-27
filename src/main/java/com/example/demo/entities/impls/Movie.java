package com.example.demo.entities.impls;

import com.example.demo.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "t_movies")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Movie extends BaseEntity {

    @Column(name = "movies_id")
    private String movieId;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_snippet_id")
    private MovieSnippet movieSnippet;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_statistics_id")
    private MovieStatistics movieStatistics;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_thumbnails_id")
    private Thumbnails thumbnails;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_casts_id")
    private List<Cast> cast;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_genres_id")
    private List<Genres> genres;
}
