package com.example.VprepU.Model;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "Users") // Explicitly specify the table name
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment primary key
    private int user_id;

    @Column(nullable = false, length = 50) // Limit username length
    private String username;

    @Column(nullable = false, unique = true, length = 100) // Unique constraint for email
    private String email;

    @Column(nullable = false) // Password must not be null
    private String password;

    @Column(nullable = false, length = 20) // Role should not exceed 20 characters
    private String role;

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime created_at;

    @Column(nullable = true, columnDefinition = "TIMESTAMP DEFAULT NULL")
    private LocalDateTime updated_at;

    // Getters and Setters
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }
}
