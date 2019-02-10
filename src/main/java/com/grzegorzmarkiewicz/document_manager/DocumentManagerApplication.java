package com.grzegorzmarkiewicz.document_manager;

import com.grzegorzmarkiewicz.document_manager.model.Document;
import com.grzegorzmarkiewicz.document_manager.model.Role;
import com.grzegorzmarkiewicz.document_manager.model.User;
import com.grzegorzmarkiewicz.document_manager.repository.CommentRepository;
import com.grzegorzmarkiewicz.document_manager.repository.DocumentRepository;
import com.grzegorzmarkiewicz.document_manager.repository.RoleRepository;
import com.grzegorzmarkiewicz.document_manager.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
        User user = createAdmin();
        userRepository.save(user);
        List<Document> documents = createDocuments(user);
        documentRepository.saveAll(documents);

        User user2 = createUser();
        userRepository.save(user2);
        List<Document> documents2 = createDocuments(user2);
        documentRepository.saveAll(documents2);
    }

    private User createUser(){
        User user = new User("grzmark","$2a$10$pcww8AjnAWKOxSJe85W86eS9Cjku.LQxr0wdpaJ9P.ZKuOt4cC42u",
                "name", "surname");
        user.setEnabled(true);
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findRoleByName("USER"));
        user.setRoles(roles);

        return user;
    }

    private User createAdmin(){
        User user = new User("grzegorz", "$2a$10$pcww8AjnAWKOxSJe85W86eS9Cjku.LQxr0wdpaJ9P.ZKuOt4cC42u",
                "Grzegorz", "Markiewicz");
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findRoleByName("USER"));
        roles.add(roleRepository.findRoleByName("MODERATOR"));
        roles.add(roleRepository.findRoleByName("ADMIN"));
        user.setRoles(roles);
        user.setEnabled(true);

        return user;
    }

    private List<Document> createDocuments(User user){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        List<Document> documents = new ArrayList<>();

        Document doc1 = new Document("doc1", "doc1_description");
        doc1.setCreationDate(timestamp);
        doc1.setLastEdited(timestamp);
        doc1.setUser(user);

        documents.add(doc1);

        Document doc2 = new Document("doc2", "doc2_description");
        doc2.setCreationDate(timestamp);
        doc2.setLastEdited(timestamp);
        doc2.setUser(user);

        documents.add(doc2);

        return documents;
    }
}

