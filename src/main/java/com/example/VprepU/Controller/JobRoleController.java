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

import com.example.VprepU.Model.JobRole;
import com.example.VprepU.Service.JobRoleService;

@RestController
@CrossOrigin
@RequestMapping("/api/job-roles")
public class JobRoleController {
    private final JobRoleService jobRoleService;

    public JobRoleController(JobRoleService jobRoleService) {
        this.jobRoleService = jobRoleService;
    }

    @PostMapping
    public JobRole createJobRole(@RequestBody JobRole jobRole) {
        return jobRoleService.saveJobRole(jobRole);
    }

    @GetMapping
    public List<JobRole> getJobRoles() {
        return jobRoleService.getAllJobRoles();
    }

    @DeleteMapping("/{roleId}")
    public void deleteJobRole(@PathVariable int roleId) {
        jobRoleService.deleteJobRole(roleId);
    }
}
