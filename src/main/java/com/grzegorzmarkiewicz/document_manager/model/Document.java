package com.grzegorzmarkiewicz.document_manager.model;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.Timestamp;
import java.util.List;

@Entity(name = "documents")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long documentId;
    private String name;
    private String description;
    private Timestamp creationDate;
    private Timestamp lastEdited;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Lob
    private Blob pdfFile;
    private String fileType;

    public Document(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Document() {
    }

    public Long getId() {
        return documentId;
    }

    public void setId(Long documentId) {
        this.documentId = documentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public Timestamp getLastEdited() {
        return lastEdited;
    }

    public void setLastEdited(Timestamp lastEdited) {
        this.lastEdited = lastEdited;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Blob getPdfFile() {
        return pdfFile;
    }

    public void setPdfFile(Blob pdfFile) {
        this.pdfFile = pdfFile;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}
