package com.grzegorzmarkiewicz.document_manager.service;

import com.grzegorzmarkiewicz.document_manager.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void saveUser(User user);

    User findByUsername(String username);

}
