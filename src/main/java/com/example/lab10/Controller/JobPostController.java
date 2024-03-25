package com.example.lab10.Controller;

import com.example.lab10.Api.ApiResponse;
import com.example.lab10.Model.JobPost;
import com.example.lab10.Repository.JobApplicationRepository;
import com.example.lab10.Service.JobPostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vi/job")
@RequiredArgsConstructor
public class JobPostController {
    private final JobPostService jobPostService;

    @GetMapping("/getJobPost")
    public ResponseEntity getJobPost(){
        return ResponseEntity.status(200).body(jobPostService.getJobPost());
    }
    @PostMapping("/addJobPost")
    public ResponseEntity addJobPost(@RequestBody @Valid JobPost jobPost , Errors errors){
        if(errors.hasErrors()){
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        jobPostService.addJobPost(jobPost);
        return ResponseEntity.ok().body(new ApiResponse("JobPost added"));

    }
    @PutMapping("/UpdateJobPost/{id}")
    public ResponseEntity UpdateJobPost(@PathVariable String id, @RequestBody @Valid JobPost jobPost , Errors errors){
        if(errors.hasErrors()){
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        Boolean isUpdate=  jobPostService.updateJobPost(id,jobPost);
        if(isUpdate) {
            return ResponseEntity.ok().body(new ApiResponse("JobPost Update"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("ID not found"));
    }


    @DeleteMapping("/deleteJobPost/{id}")
    public ResponseEntity deleteJobPost(@PathVariable String id){

        Boolean isDeleted=  jobPostService.deleteJobPost(id);
        if(isDeleted) {
            return ResponseEntity.ok().body(new ApiResponse("JobPost Deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("ID not found"));
    }
}
