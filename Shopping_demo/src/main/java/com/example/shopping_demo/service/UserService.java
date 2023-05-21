package com.example.shopping_demo.service;

import com.example.shopping_demo.entity.User;
import com.example.shopping_demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User registerUser(User user) {
        return userRepository.save(user);
    }
    public User getUser(Long user_id) {
        return userRepository.findById(user_id).orElse(null);
    }

    public User updateUser(Long user_id, User updateUser) {
        User user = userRepository.findById(user_id).orElse(null);
        if (user != null) {

            user.setUsername(updateUser.getUsername());
            user.setEmail(updateUser.getEmail());
            user.setPassword(updateUser.getPassword());
            user.setPhoneNumber(updateUser.getPhoneNumber());
            user.setModifiedDate(LocalDateTime.now());

            return userRepository.save(user);
        }
        return null;
    }

    public boolean deleteUser(Long user_id) {
        if (userRepository.existsById(user_id)) {
            userRepository.deleteById(user_id);
            return true;
        }
        return false;
    }

}
