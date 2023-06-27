package com.example.demo.respository;

import com.example.demo.entities.impls.Cast;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface CastRepository extends JpaRepository<Cast, Long> {
}
