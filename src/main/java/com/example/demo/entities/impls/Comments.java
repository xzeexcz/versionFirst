package com.example.demo.entities.impls;

import com.example.demo.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "t_blog_comments")
@Getter
@Setter
public class Comments extends BaseEntity {
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "c_author")
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "c_blogs")
    private Blogs blogs;
    @Column(name = "c_comment", columnDefinition = "TEXT")
    private String comment;
    @Column(name = "c_postDate")
    private Date postDate;
}
