package com.example.lab10.Controller;

import com.example.lab10.Api.ApiResponse;
import com.example.lab10.Model.JobApplication;
import com.example.lab10.Repository.JobApplicationRepository;
import com.example.lab10.Service.JobApplicationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vi/job")
@RequiredArgsConstructor
public class JobApplicationController {
    private final JobApplicationService jobApplicationService;

    @GetMapping("/get")
    public ResponseEntity getJobApplication(){
        return ResponseEntity.status(200).body(jobApplicationService.getJobApplication());
    }
    @PostMapping("/add")
    public ResponseEntity addJobApplication(@RequestBody @Valid JobApplication jobApplication , Errors errors){
        if(errors.hasErrors()){
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        jobApplicationService.addJobApplication(jobApplication);
        return ResponseEntity.ok().body(new ApiResponse("JobApplication added"));

    }
    @PutMapping("/Update/{id}")
    public ResponseEntity UpdateJobApplication(@PathVariable String id, @RequestBody @Valid JobApplication jobApplication , Errors errors){
        if(errors.hasErrors()){
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        Boolean isUpdate=  jobApplicationService.updateJobApplication(id,jobApplication);
        if(isUpdate) {
            return ResponseEntity.ok().body(new ApiResponse("JobApplication Update"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("ID not found"));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteJobApplication(@PathVariable String id){

        Boolean isDeleted=  jobApplicationService.deleteJobApplication(id);
        if(isDeleted) {
            return ResponseEntity.ok().body(new ApiResponse("JobApplication Deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("ID not found"));
    }
}
