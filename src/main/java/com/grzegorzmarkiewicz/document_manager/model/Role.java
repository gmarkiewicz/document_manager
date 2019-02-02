package com.grzegorzmarkiewicz.document_manager.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;
    private String name;
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;
}
