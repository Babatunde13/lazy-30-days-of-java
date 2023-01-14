package com.day5.day5.services;

import org.springframework.stereotype.Service;

import com.day5.day5.data.User;
import com.day5.day5.data.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isValidCredentials(String username, String password) {
        User user = userRepository.findUserByUsername(username);
        return user != null && user.verifyPassword(password);
    }

    public User getUser(String username) {
        return userRepository.findUserByUsername(username);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public boolean userExists(String username) {
        return userRepository.findUserByUsername(username) != null;
    }

    public User deleteUser(String username) {
        User user = userRepository.findUserByUsername(username);
        if (user == null) {
            return null;
        }
        userRepository.delete(user);
        return user;
    }
}
