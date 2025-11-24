package com.comment_service.comment_service.repo;

import com.comment_service.comment_service.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {}
