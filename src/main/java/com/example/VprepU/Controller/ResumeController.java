package com.example.VprepU.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.VprepU.Model.Resume;
import com.example.VprepU.Service.ResumeService;

@RestController
@CrossOrigin
@RequestMapping("/api/resumes")
public class ResumeController {

    private final ResumeService resumeService;

   
    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    // Create a new resume
    @PostMapping
    public Resume createResume(@RequestBody Resume resume) {
        return resumeService.saveResume(resume);
    }

    // Get all resumes
    @GetMapping
    public List<Resume> getAllResumes() {
        return resumeService.getAllResumes();
    }

    // Get a specific resume by ID
    @GetMapping("/{resumeId}")
    public Resume getResumeById(@PathVariable int resumeId) {
    	Resume resume = resumeService.getResumeById(resumeId);
        if (resume == null) {
            throw new RuntimeException("Resume not found with ID: " + resumeId);
        }
        return resume;
    }

    // Update a specific resume
    @PutMapping("/{resumeId}")
    public Resume updateResume(@PathVariable int resumeId, @RequestBody Resume updatedResume) {
        return resumeService.updateResume(resumeId, updatedResume);
    }

    // Delete a specific resume by ID
    @DeleteMapping("/{resumeId}")
    public String deleteResume(@PathVariable int resumeId) {
        resumeService.deleteResume(resumeId);
        return "Resume with ID " + resumeId + " has been deleted successfully.";
    }
}
