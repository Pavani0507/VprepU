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
@Table(name = "interview_sessions") // Added table name for better clarity
public class InterviewSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sessionId; // Renamed to camelCase

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "user_id")
    private User user;

    private String jobRole; // Renamed to camelCase
    private LocalDateTime sessionDate; // Renamed to camelCase
    private String sessionFeedback; // Renamed to camelCase
    private String audioRecordingPath; // Renamed to camelCase
    private int score;
    private LocalDateTime createdAt; // Renamed to camelCase

    // Getters and Setters

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    public LocalDateTime getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(LocalDateTime sessionDate) {
        this.sessionDate = sessionDate;
    }

    public String getSessionFeedback() {
        return sessionFeedback;
    }

    public void setSessionFeedback(String sessionFeedback) {
        this.sessionFeedback = sessionFeedback;
    }

    public String getAudioRecordingPath() {
        return audioRecordingPath;
    }

    public void setAudioRecordingPath(String audioRecordingPath) {
        this.audioRecordingPath = audioRecordingPath;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
