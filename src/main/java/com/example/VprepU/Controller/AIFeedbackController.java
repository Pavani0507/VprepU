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

import com.example.VprepU.Model.AIFeedback;
import com.example.VprepU.Service.AIFeedbackService;

@RestController
@CrossOrigin
@RequestMapping("/api/ai-feedback")
public class AIFeedbackController {
    private final AIFeedbackService feedbackService;

    public AIFeedbackController(AIFeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping
    public AIFeedback createFeedback(@RequestBody AIFeedback feedback) {
        return feedbackService.saveFeedback(feedback);
    }

    @GetMapping
    public List<AIFeedback> getFeedback() {
        return feedbackService.getAllFeedback();
    }

    @DeleteMapping("/{feedbackId}")
    public void deleteFeedback(@PathVariable int feedbackId) {
        feedbackService.deleteFeedback(feedbackId);
    }
}


