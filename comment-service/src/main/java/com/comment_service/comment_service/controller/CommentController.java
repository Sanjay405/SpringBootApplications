package com.comment_service.comment_service.controller;

import com.comment_service.comment_service.entity.Comment;
import com.comment_service.comment_service.repo.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {
    @Autowired private CommentRepository repo;

    @PostMapping
    public Comment addComment(@RequestBody Comment comment) {
        return repo.save(comment);
    }

    @GetMapping("/post/{postId}")
    public List<Comment> getComments(@PathVariable Long postId) {
        return repo.findAll().stream()
                .filter(c -> c.getPostId().equals(postId))
                .toList();
    }
}
