package com.example.demo.respository.videos;

import com.example.demo.entities.impls.VideoThumbnails;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
public interface VideoThumbnailsRepository extends JpaRepository<VideoThumbnails, Long> {
}
