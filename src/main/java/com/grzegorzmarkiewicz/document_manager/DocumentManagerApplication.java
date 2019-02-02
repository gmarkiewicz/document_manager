package com.grzegorzmarkiewicz.document_manager;

import com.grzegorzmarkiewicz.document_manager.model.Role;
import com.grzegorzmarkiewicz.document_manager.model.User;
import com.grzegorzmarkiewicz.document_manager.repository.CommentRepository;
import com.grzegorzmarkiewicz.document_manager.repository.DocumentRepository;
import com.grzegorzmarkiewicz.document_manager.repository.RoleRepository;
import com.grzegorzmarkiewicz.document_manager.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class DocumentManagerApplication implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final DocumentRepository documentRepository;

    public DocumentManagerApplication(RoleRepository roleRepository, CommentRepository commentRepository,
                                      UserRepository userRepository, DocumentRepository documentRepository) {
        this.roleRepository = roleRepository;
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.documentRepository = documentRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(DocumentManagerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User("grzegorz", "haslo1", "Grzegorz", "Markiewicz");
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findRoleByName("USER"));
        roles.add(roleRepository.findRoleByName("MODERATOR"));
        roles.add(roleRepository.findRoleByName("ADMIN"));
        user.setRoles(roles);

        userRepository.save(user);
    }
}

