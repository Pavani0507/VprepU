package com.example.VprepU.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.VprepU.Model.AIFeedback;
import com.example.VprepU.Repository.AIFeedbackRepository;

@Service
public class AIFeedbackService {
	private final AIFeedbackRepository feedbackRepository;

    public AIFeedbackService(AIFeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public AIFeedback saveFeedback(AIFeedback feedback) {
        feedback.setCreatedAt(LocalDateTime.now());
        return feedbackRepository.save(feedback);
    }

    public List<AIFeedback> getAllFeedback() {
        return feedbackRepository.findAll();
    }

    public void deleteFeedback(int feedbackId) {
        feedbackRepository.deleteById(feedbackId);
    }
}
