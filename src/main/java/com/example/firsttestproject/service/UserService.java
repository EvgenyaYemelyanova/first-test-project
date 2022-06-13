package com.example.firsttestproject.service;

import com.example.firsttestproject.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user);
    User getUserById(long id);
    List<User> getAllUsers();
}
