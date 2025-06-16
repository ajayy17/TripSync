package com.tripsync.userservice.controller;

import com.tripsync.userservice.model.User;
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
    public ResponseEntity<User> registerUser(@RequestBody User user){
        userService.addUser(user);
        return new ResponseEntity<>(user,HttpStatus.CREATED);
    }

    @GetMapping("admin/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.FOUND);
    }

    @GetMapping("admin/getUserByName")
    public ResponseEntity<User> getUserByName(@PathVariable String name){
        User user = userService.getUserByName(name);
        return new ResponseEntity<>(user, HttpStatus.FOUND);
    }

    @DeleteMapping("admin/deleteUser")
    public ResponseEntity<User> deleteUser(@PathVariable String name){
        User user = userService.deteleUser(name);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("user/updateUser")
    public ResponseEntity<User> updateUser(@PathVariable String name){
        User user = userService.updateUser(name);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
