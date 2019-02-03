package com.grzegorzmarkiewicz.document_manager.repository;

import com.grzegorzmarkiewicz.document_manager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
