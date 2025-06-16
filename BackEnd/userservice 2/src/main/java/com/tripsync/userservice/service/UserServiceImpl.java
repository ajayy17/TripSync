package com.tripsync.userservice.service;

import com.tripsync.userservice.model.User;
import com.tripsync.userservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User deteleUser(String name) {
        User user = userRepository.findByUserName(name);
        if(user.getUserName().equals(name)) userRepository.delete(user);
        return user;
    }

    @Override
    public User updateUser(String name) {
        User user = userRepository.findByUserName(name);
        if(user.getUserName().equals(name)) {
            user.setUserName(name);
            userRepository.save(user);
        }
        return user;
    }

    @Override
    public User getUserByName(String name) {
        return userRepository.findByUserName(name);
    }
}
