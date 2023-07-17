package com.example.demo.respository;

import com.example.demo.entities.impls.Comments;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface CommentRepository extends JpaRepository<Comments, Long> {
    List<Comments> findCommentsByBlogs_Id(Long id);

    @Query(value = "SELECT * FROM t_blog_comments ORDER BY c_post_date DESC 5", nativeQuery = true)
    List<Comments> findLatestComments();

}
