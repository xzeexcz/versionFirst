package com.example.demo.respository.videos;

import com.example.demo.entities.impls.VideoType;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface VideoTypeRepository extends JpaRepository<VideoType, Long> {
}
