package com.kanbanian.repository;

import com.kanbanian.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;

public interface CommentRepo extends JpaRepository<Comment, Id> {
}
