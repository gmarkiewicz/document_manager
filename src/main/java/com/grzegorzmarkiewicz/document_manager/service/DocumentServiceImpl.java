package com.grzegorzmarkiewicz.document_manager.service;

import com.grzegorzmarkiewicz.document_manager.model.Document;
import com.grzegorzmarkiewicz.document_manager.repository.DocumentRepository;
import com.grzegorzmarkiewicz.document_manager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Document> findAllByUserId(Long userId) {
       return documentRepository.findAll()
                .stream()
                .filter( e -> e.getUser().getId().equals(userId))
                .collect(Collectors.toList());
    }
}
