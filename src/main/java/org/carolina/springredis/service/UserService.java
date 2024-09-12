package org.carolina.springredis.service;

import org.carolina.springredis.entity.User;
import org.carolina.springredis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Cacheable(value = "users", key = "#id")
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public ResponseEntity<?> registerUser(RegisterRequest request) {
        // Logic for registering users
    }

    public ResponseEntity<?> authenticateUser(LoginRequest request) {
        // Logic for authenticating users and generating tokens
    }
}
