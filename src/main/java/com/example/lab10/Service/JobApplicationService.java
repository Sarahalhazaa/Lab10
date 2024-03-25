package com.example.lab10.Service;

import com.example.lab10.Model.JobApplication;
import com.example.lab10.Repository.JobApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobApplicationService {

    private final JobApplicationRepository jobApplicationRepository;
    public List<JobApplication> getJobApplication() {
        return jobApplicationRepository.findAll();
    }

    public void addJobApplication(JobApplication jobApplication) {
       jobApplicationRepository.save(jobApplication);
    }

    public boolean updateJobApplication(String id, JobApplication jobApplication) {

        JobApplication c = jobApplicationRepository.getById(id);
        if(c==null) {
            return false;
        }
        c.setUserId(jobApplication.getUserId());
        c.setJobPostId(jobApplication.getJobPostId());
       jobApplicationRepository.save(c);
        return true;
    }

    public boolean deleteJobApplication(String id) {
        JobApplication c = jobApplicationRepository.getById(id);
        if(c==null) {
            return false;
        }
        jobApplicationRepository.delete(c);
        return true;
    }
}
