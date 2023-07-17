package com.example.demo.restControllers;

import com.example.demo.entities.impls.Comments;
import com.example.demo.respository.CommentRepository;
import com.example.demo.services.CommentService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/comments")
@RequiredArgsConstructor
public class CommentsController {
    private final CommentService commentService;
    private final CommentRepository commentRepository;
    @PostMapping(value = "/add")
    public Comments addComment(@RequestBody Comments comments) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        System.out.println(email);
        return commentService.addComment(comments, email);
    }
    @GetMapping
    public List<Comments> get() {
        return commentRepository.findAll();
    }
    @GetMapping(value = "/{id}")
    public List<Comments> getO(@PathVariable Long id) {
        return commentRepository.findCommentsByBlogs_Id(id);
    }

    @GetMapping(value = "/latest")
    public List<Comments> getLatestComments() {
        return commentRepository.findLatestComments();
    }


}
