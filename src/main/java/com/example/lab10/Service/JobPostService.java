package com.example.lab10.Service;

import com.example.lab10.Model.JobPost;
import com.example.lab10.Repository.JobPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobPostService {
    private final JobPostRepository jobPostRepository;
    // private final ProductService productService;
    public List<JobPost> getJobPost() {
        return jobPostRepository.findAll();
    }

    public void addJobPost(JobPost jobPost) {
        jobPostRepository.save(jobPost);
    }

    public boolean updateJobPost(String id, JobPost jobPost) {

        JobPost c = jobPostRepository.getById(id);
        if(c==null) {
            return false;
        }
        c.setTitle(jobPost.getTitle());
        c.setDescription(jobPost.getDescription());
        c.setLocation(jobPost.getLocation());
        c.setSalary(jobPost.getSalary());
        c.setPostingDate(jobPost.getPostingDate());
       jobPostRepository.save(c);
        return true;
    }

    public boolean deleteJobPost(String id) {
        JobPost jobPost =jobPostRepository.getById(id);
        if(jobPost==null) {
            return false;
        }
        jobPostRepository.delete(jobPost);
        return true;
    }
}
