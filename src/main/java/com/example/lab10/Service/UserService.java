package com.example.lab10.Service;

import com.example.lab10.Controller.UserController;
import com.example.lab10.Model.User;
import com.example.lab10.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getUser() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public boolean updateUser(String id, User user) {
        User user1 = userRepository.getById(id);
        if(user==null) {
            return false;
        }
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());
        user1.setAge(user.getAge());
        user1.setRole(user.getRole());
        userRepository.save(user1);
        return true;
    }

    public boolean deleteUser(String id) {
        User user = userRepository.getById(id);
        if(user==null) {
            return false;
        }
        userRepository.delete(user);
        return true;
    }


}
