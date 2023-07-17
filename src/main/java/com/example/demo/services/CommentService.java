package com.example.demo.services;

import com.example.demo.entities.impls.Comments;

public interface CommentService {
    Comments addComment(Comments comments, String email);
}
