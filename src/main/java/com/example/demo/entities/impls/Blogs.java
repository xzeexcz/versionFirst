package com.example.demo.entities.impls;

import com.example.demo.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "t_blogs")
@Getter
@Setter
public class Blogs extends BaseEntity {
    @Column(name = "b_title")
    private String title;
    @Column(name = "b_description", columnDefinition = "TEXT")
    private String description;
    @Column(name = "b_postDate")
    private LocalDate postDate;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "b_author")
    private User author;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "b_blogs_categories")
    private List<Categories> categoriesList ;

}