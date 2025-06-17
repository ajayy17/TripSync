package com.tripsync.userservice.service;

import com.tripsync.userservice.payload.LoginDTO;
import com.tripsync.userservice.payload.UserDTO;

import java.util.List;

public interface UserService {
    void addUser(UserDTO userDTO);
    List<UserDTO> getAllUsers();
    UserDTO deleteUser(String name);
    UserDTO updateUser(String name, UserDTO userDTO);
    UserDTO getUserByName(String name);
//    UserDTO getUserByEmail(LoginDTO loginDTO);
    //LoginDTO loginUser(LoginDTO loginDTO);
}
