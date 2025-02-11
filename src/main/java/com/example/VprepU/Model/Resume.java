package com.example.VprepU.Model;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "resumes") // Added table annotation for better clarity
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int resumeId; // Changed variable name to follow camelCase convention

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "user_id")
    private User user;

    @ManyToOne // Assuming template is also many-to-one relation
    @JoinColumn(name = "templateId", referencedColumnName = "templateId")
    private Template template;

    private String resumeData; // Renamed to follow camelCase
    private LocalDateTime createdAt; // Renamed to follow camelCase
    private LocalDateTime updatedAt; // Renamed to follow camelCase

    // Getters and Setters

    public int getResumeId() {
        return resumeId;
    }

    public void setResumeId(int resumeId) {
        this.resumeId = resumeId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }

    public String getResumeData() {
        return resumeData;
    }

    public void setResumeData(String resumeData) {
        this.resumeData = resumeData;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
