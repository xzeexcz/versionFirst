package com.example.demo.entities.impls;

import com.example.demo.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "t_blog_categories")
@Getter
@Setter
public class Categories extends BaseEntity {
    @Column(name = "c_name")
    private String categoryName;
}
