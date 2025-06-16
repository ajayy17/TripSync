package com.tripsync.userservice.controller;

import com.tripsync.userservice.payload.UserDTO;
import com.tripsync.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tripSync/api/")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("user/registerUser")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO){
        userService.addUser(userDTO);
        return new ResponseEntity<>(userDTO,HttpStatus.CREATED);
    }

    @GetMapping("admin/getAllUsers")
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        List<UserDTO> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.FOUND);
    }

    @GetMapping("admin/getUserByName/{name}")
    public ResponseEntity<UserDTO> getUserByName(@PathVariable String name){
        UserDTO userDTO = userService.getUserByName(name);
        return new ResponseEntity<>(userDTO, HttpStatus.FOUND);
    }

    @DeleteMapping("admin/deleteUser/{name}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable String name){
        UserDTO userDTO = userService.deleteUser(name);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @PutMapping("user/updateUser/{name}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable String name, @RequestBody UserDTO user){
        System.out.println("user from request name" +user.getUserName());
        System.out.println("user from request email" +user.getEmail());
        System.out.println("user from request pass" +user.getPassword());
        UserDTO updatedUser = userService.updateUser(name, user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
}
