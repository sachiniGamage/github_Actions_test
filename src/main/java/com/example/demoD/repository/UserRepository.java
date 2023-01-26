package com.example.demoD.repository;

import com.example.demoD.model.User;
import com.example.demoD.model.UserRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);
}
