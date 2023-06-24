package com.example.demo.entities.impls;

import com.example.demo.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
}
