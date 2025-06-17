package com.tripsync.userservice.service;

import com.tripsync.userservice.exceptions.ResourceNotFoundException;
import com.tripsync.userservice.model.User;
import com.tripsync.userservice.payload.LoginDTO;
import com.tripsync.userservice.payload.UserDTO;
import com.tripsync.userservice.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UserRepository userRepository;

    @Override
    public void addUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        userRepository.save(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .toList();
    }

    @Override
    public UserDTO deleteUser(String name) {
        User user = userRepository.findByUserName(name);

        if(user == null)
            throw new ResourceNotFoundException("User", "username", name);

        if(user.getUserName().equals(name)) userRepository.delete(user);
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public UserDTO updateUser(String name, UserDTO userDTO) {
        User returnedUser = userRepository.findByUserName(name);

        if(returnedUser.getUserName().equals(name)) {
            returnedUser.setUserName(userDTO.getUserName());
            returnedUser.setEmail(userDTO.getEmail());
            returnedUser.setPassword(userDTO.getPassword());
            userRepository.save(returnedUser);
        }
        return modelMapper.map(returnedUser, UserDTO.class);
    }

    @Override
    public UserDTO getUserByName(String name) {
        User user = userRepository.findByUserName(name);
        if(user == null){
            throw new ResourceNotFoundException("User", "userName", name);
        }
        return modelMapper.map(user, UserDTO.class);
    }

    public UserDTO getUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if(user == null){
            throw new ResourceNotFoundException("User", "userName", email);
        }
        return modelMapper.map(user, UserDTO.class);
    }


//    public LoginDTO loginUser(LoginDTO loginDTO)
//    {
//        UserDTO userDTO= getUserByEmail(loginDTO.getEmail());
//
//
//        return null;
//    }
}
