package com.example.demo.respository;

import com.example.demo.entities.impls.FavoriteMovies;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface FavoriteMoviesRepository extends JpaRepository<FavoriteMovies, Long> {
    List<FavoriteMovies> findAllByUser_Id(Long id);
}
