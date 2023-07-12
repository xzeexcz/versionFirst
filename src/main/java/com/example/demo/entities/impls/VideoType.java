package com.example.demo.entities.impls;

import com.example.demo.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "t_video_type")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VideoType extends BaseEntity {
    @Column(name = "t_video_typeName")
    private String videoTypeName;
}
