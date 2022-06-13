package com.example.firsttestproject.service.impl;

import com.example.firsttestproject.exception.UsernameNotFoundException;
import com.example.firsttestproject.model.User;
import com.example.firsttestproject.repositories.UserRepository;
import com.example.firsttestproject.service.UserService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException(String.format("User with id '%d' not found", id))
        );
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}