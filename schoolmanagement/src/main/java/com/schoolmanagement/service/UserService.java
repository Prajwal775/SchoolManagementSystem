package com.schoolmanagement.service;

import com.schoolmanagement.entity.User;
import com.schoolmanagement.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Get all users (students or teachers)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Save a new user (student or teacher)
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Get a user by their ID
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    // Delete a user by their ID
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
