package com.grzegorzmarkiewicz.document_manager.repository;

import com.grzegorzmarkiewicz.document_manager.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {

    Document findByUserId(Long id);
}
