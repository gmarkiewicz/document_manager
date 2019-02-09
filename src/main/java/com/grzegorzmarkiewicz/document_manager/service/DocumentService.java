package com.grzegorzmarkiewicz.document_manager.service;

import com.grzegorzmarkiewicz.document_manager.model.Document;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DocumentService {
    List<Document> findAllByUserId(Long userId);
}
