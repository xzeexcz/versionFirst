package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class VideosController {
    @GetMapping(value = "/videos")
    public String videosHome() {
        return "videos-home";
    }
    @GetMapping(value = "/videos/{videoId}/details")
    public String videoDetails(@PathVariable String videoId){
        return "video-details";
    }
    @GetMapping(value = "/upload-video")
    public String uploadVideo() {
        return "add-video";
    }
}
