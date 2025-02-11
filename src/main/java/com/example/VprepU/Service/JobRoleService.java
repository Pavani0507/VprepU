package com.example.VprepU.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.VprepU.Model.JobRole;
import com.example.VprepU.Repository.JobRoleRepository;

@Service
public class JobRoleService {
	private final JobRoleRepository jobRoleRepository;
	public JobRoleService(JobRoleRepository jobRoleRepository) {
        this.jobRoleRepository = jobRoleRepository;
    }

    public JobRole saveJobRole(JobRole jobRole) {
        return jobRoleRepository.save(jobRole);
    }

    public List<JobRole> getAllJobRoles() {
        return jobRoleRepository.findAll();
    }

    public void deleteJobRole(int roleId) {
        jobRoleRepository.deleteById(roleId);
    }
}
