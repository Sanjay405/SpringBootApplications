package com.post_service.post_service.repo;

import com.post_service.post_service.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {}
