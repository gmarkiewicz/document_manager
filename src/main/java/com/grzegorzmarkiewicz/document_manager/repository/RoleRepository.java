package com.grzegorzmarkiewicz.document_manager.repository;

import com.grzegorzmarkiewicz.document_manager.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findRoleByName(String name);
}
