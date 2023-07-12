package com.example.demo.restControllers;

import com.example.demo.entities.impls.Blogs;
import com.example.demo.respository.BlogsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/blogs/all")
public class BlogController {
    private final BlogsRepo blogsRepo;
    @GetMapping
    public List<Blogs> getAll() {
        return blogsRepo.findAll();
    }
}
