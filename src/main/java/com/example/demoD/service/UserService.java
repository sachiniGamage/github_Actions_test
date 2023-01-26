package com.example.demoD.service;

import com.example.demoD.model.User;
import com.example.demoD.model.UserRequest;
import com.example.demoD.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final  UserRepository userRepository;

    public void createUser(UserRequest userRequest) {
        User user = new User();
        Optional<User> user1 = userRepository.findByUsername(userRequest.getUsername());
        if(user1.isPresent()){
            throw new RuntimeException("User already registered");
        }
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        userRepository.save(user);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
