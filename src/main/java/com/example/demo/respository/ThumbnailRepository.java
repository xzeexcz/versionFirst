package com.example.demo.respository;

import com.example.demo.entities.impls.Thumbnail;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ThumbnailRepository extends JpaRepository<Thumbnail, Long> {
}
