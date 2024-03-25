package com.example.lab10.Controller;

import com.example.lab10.Api.ApiResponse;
import com.example.lab10.Model.User;
import com.example.lab10.Repository.JobApplicationRepository;
import com.example.lab10.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vi/job")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @GetMapping("/getUser")
    public ResponseEntity getUser(){
        return ResponseEntity.status(200).body(userService.getUser());
    }

    @PostMapping("/addUser")
    public ResponseEntity addUser(@RequestBody @Valid User user , Errors errors){
        if(errors.hasErrors()){
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
       userService.addUser(user);
        return ResponseEntity.ok().body(new ApiResponse("User added"));

    }
    @PutMapping("/UpdateUser/{id}")
    public ResponseEntity UpdateUser(@PathVariable String id, @RequestBody @Valid User user , Errors errors){
        if(errors.hasErrors()){
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        Boolean isUpdate=  userService.updateUser(id,user);
        if(isUpdate) {
            return ResponseEntity.ok().body(new ApiResponse("User Update"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("ID not found"));
    }


    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity deleteUser(@PathVariable String id){

        Boolean isDeleted= userService.deleteUser(id);
        if(isDeleted) {
            return ResponseEntity.ok().body(new ApiResponse("User Deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("ID not found"));
    }
}
