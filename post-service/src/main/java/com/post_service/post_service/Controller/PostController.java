package com.post_service.post_service.Controller;
import com.netflix.discovery.converters.Auto;
import com.post_service.post_service.entity.Post;
import com.post_service.post_service.repo.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    @Autowired
    private  PostRepository repo;

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return repo.save(post);
    }

    @GetMapping
    public List<Post> getAllPosts() {
        return repo.findAll();
    }
}

