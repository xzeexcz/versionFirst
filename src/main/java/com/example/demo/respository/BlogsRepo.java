package com.example.demo.respository;

import com.example.demo.entities.impls.Blogs;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface BlogsRepo extends JpaRepository<Blogs, Long> {
}
