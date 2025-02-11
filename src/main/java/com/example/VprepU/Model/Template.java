package com.example.VprepU.Model;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "Templates")
public class Template {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int templateId; // Renamed to camelCase

    @Column(nullable = false, length = 100)
    private String templateName; // Renamed to camelCase

    @Lob
    @Column(nullable = false)
    private String templateDescription; // Renamed to camelCase

    @Lob
    @Column(nullable = false)
    private String templateStructure; // Renamed to camelCase

    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt; // Renamed to camelCase
    
    // Add a version field
    @Version
    @Column(name = "version")
    private int version;

    // Default constructor
    public Template() {
    }

    // Getters and Setters
    public int getTemplateId() {
        return templateId;
    }

    public void setTemplateId(int templateId) {
        this.templateId = templateId;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getTemplateDescription() {
        return templateDescription;
    }

    public void setTemplateDescription(String templateDescription) {
        this.templateDescription = templateDescription;
    }

    public String getTemplateStructure() {
        return templateStructure;
    }

    public void setTemplateStructure(String templateStructure) {
        this.templateStructure = templateStructure;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
