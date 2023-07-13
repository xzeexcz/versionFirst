package com.example.demo.services.impls;

import com.example.demo.entities.impls.Blogs;
import com.example.demo.respository.BlogsRepo;
import com.example.demo.services.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlogServiceImpl implements BlogService {
    private final BlogsRepo blogsRepo;
    @Override
    public Blogs getOneBlogById(Long id) {
        return blogsRepo.findById(id).orElseThrow();
    }
}
