package com.example.demo.entities.impls;


import com.example.demo.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_movies_statistics")
@Getter
@Setter
public class MovieStatistics extends BaseEntity {

    @Column(name = "m_statistics_likesCount")
    private Long likesCount;
    @Column(name = "m_statistics_viewsCount")
    private Long viewsCount;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_id")
    private Movie movie;
}
