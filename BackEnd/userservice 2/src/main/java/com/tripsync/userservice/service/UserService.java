package com.tripsync.userservice.service;

import com.tripsync.userservice.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    List<User> getAllUsers();
    User deteleUser(String name);
    User updateUser(String name);
    User getUserByName(String name);
}
