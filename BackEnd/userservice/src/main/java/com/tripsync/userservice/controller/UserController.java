package com.tripsync.userservice.controller;

import com.tripsync.userservice.payload.LoginDTO;
import com.tripsync.userservice.payload.UserDTO;
import com.tripsync.userservice.security.jwt.JwtUtils;
import com.tripsync.userservice.security.response.MessageResponse;
import com.tripsync.userservice.security.response.UserInfoResponse;
import com.tripsync.userservice.security.services.UserDetailsImpl;
import com.tripsync.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("tripSync/api/")
public class UserController {
    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @PostMapping("user/registerUser")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO){
        userService.addUser(userDTO);
        return new ResponseEntity<>(userDTO,HttpStatus.CREATED);
    }

//    @PostMapping("user/loginUser")
//    public ResponseEntity<LoginDTO> loginUser(@RequestBody LoginDTO loginDTO){
//
//        userService.loginUser(loginDTO);
//        return new ResponseEntity<>(loginDTO,HttpStatus.OK);
//    }

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

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginDTO loginRequest) {
        Authentication authentication;
        try {
            authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        } catch (AuthenticationException exception) {
            Map<String, Object> map = new HashMap<>();
            map.put("message", "Bad credentials");
            map.put("status", false);
            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

        String roles = userDetails.getRole();

        UserInfoResponse response = new UserInfoResponse(userDetails.getId(),userDetails.getUsername(), roles, jwtCookie.getValue());


        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE,
                        jwtCookie.getValue())
                .body(response);
    }

    @PostMapping("/signout")
    public ResponseEntity<?> signoutUser(){
        ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE,
                        cookie.toString())
                .body(new MessageResponse("You've been signed out"));
    }

}
