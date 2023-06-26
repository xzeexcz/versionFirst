package com.example.demo.entities.impls;

import com.example.demo.entities.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "t_movies_genres")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Genres extends BaseEntity {

}
