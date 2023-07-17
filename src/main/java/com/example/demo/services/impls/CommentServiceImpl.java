package com.example.demo.services.impls;

import com.example.demo.entities.impls.Blogs;
import com.example.demo.entities.impls.Comments;
import com.example.demo.entities.impls.User;
import com.example.demo.respository.BlogsRepo;
import com.example.demo.respository.CommentRepository;
import com.example.demo.respository.UserRepository;
import com.example.demo.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final BlogsRepo blogsRepo;
    @Override
    public Comments addComment(Comments comments, String email) {
        Comments addComment = new Comments();
        addComment.setComment(comments.getComment());
        addComment.setPostDate(comments.getPostDate());
        Blogs blogs = blogsRepo.findById(comments.getBlogs().getId()).orElseThrow();
        addComment.setBlogs(blogs);
        User user = userRepository.findByEmail(email);
        addComment.setUsers(user);
        return commentRepository.save(addComment);
    }


}
