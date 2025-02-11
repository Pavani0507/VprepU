package com.example.VprepU.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.VprepU.Model.Resume;
import com.example.VprepU.Repository.ResumeRepository;

@Service
public class ResumeService {
	private final ResumeRepository resumeRepository;

    public ResumeService(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }

    public Resume saveResume(Resume resume) {
        return resumeRepository.save(resume);
    }

    public List<Resume> getAllResumes() {
        return resumeRepository.findAll();
    }

    public void deleteResume(int resumeId) {
        resumeRepository.deleteById(resumeId);
    }

	public Resume getResumeById(int resumeId) {
		return resumeRepository.findById(resumeId).orElse(null);
	}

	public Resume updateResume(int resumeId, Resume updatedResume) {
		
		Optional<Resume> existingResumeOptional = resumeRepository.findById(resumeId);

        if (existingResumeOptional.isPresent()) {
            Resume existingResume = existingResumeOptional.get();
            existingResume.setTemplate(updatedResume.getTemplate());
            existingResume.setResumeData(updatedResume.getResumeData());
            existingResume.setUpdatedAt(updatedResume.getUpdatedAt() != null ? updatedResume.getUpdatedAt() : LocalDateTime.now());

            return resumeRepository.save(existingResume);
        } else {
            throw new RuntimeException("Resume not found with ID: " + resumeId);
        }
    }
	
}
