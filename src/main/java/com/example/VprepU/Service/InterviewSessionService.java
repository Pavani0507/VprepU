package com.example.VprepU.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.VprepU.Model.InterviewSession;
import com.example.VprepU.Repository.InterviewSessionRepository;

@Service
public class InterviewSessionService {
	private final InterviewSessionRepository sessionRepository;

    public InterviewSessionService(InterviewSessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public InterviewSession saveSession(InterviewSession session) {
        return sessionRepository.save(session);
    }

    public List<InterviewSession> getAllSessions() {
        return sessionRepository.findAll();
    }

    public void deleteSession(int sessionId) {
        sessionRepository.deleteById(sessionId);
    }
}
