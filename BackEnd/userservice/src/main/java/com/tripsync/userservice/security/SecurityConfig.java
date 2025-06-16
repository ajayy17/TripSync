package com.tripsync.userservice.security;

import com.tripsync.userservice.repository.UserRepository;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
public class SecurityConfig{

    private UserRepository userRepository;

    public SecurityConfig(UserRepository userRepository){

    }

}
