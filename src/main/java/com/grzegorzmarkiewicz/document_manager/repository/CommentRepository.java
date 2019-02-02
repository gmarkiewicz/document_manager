package com.grzegorzmarkiewicz.document_manager.repository;

import com.grzegorzmarkiewicz.document_manager.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
