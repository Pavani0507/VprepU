package com.example.VprepU.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.VprepU.Model.InterviewSession;
import com.example.VprepU.Service.InterviewSessionService;

@RestController
@CrossOrigin
@RequestMapping("/api/interview-sessions")
public class InterviewSessionController {
    private final InterviewSessionService sessionService;

    public InterviewSessionController(InterviewSessionService sessionService) {
        this.sessionService = sessionService;
    }

    @PostMapping
    public InterviewSession createSession(@RequestBody InterviewSession session) {
        return sessionService.saveSession(session);
    }

    @GetMapping
    public List<InterviewSession> getSessions() {
        return sessionService.getAllSessions();
    }

    @DeleteMapping("/{sessionId}")
    public void deleteSession(@PathVariable int sessionId) {
        sessionService.deleteSession(sessionId);
    }
}

