package com.proyecto.ieti.pemc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Replace this with your own user lookup logic
        Optional<com.proyecto.ieti.pemc.entity.User> userOpt = Optional.ofNullable(userService.findByEmail(username));
        
        // Handle user not found
        com.proyecto.ieti.pemc.entity.User user = userOpt.orElseThrow(() ->
            new UsernameNotFoundException("User not found with username: " + username));

        return User.withUsername(user.getEmail())
                   .password(user.getPasswordHash()) // Ensure password is encrypted
                   .roles("USER") // Customize roles as needed
                   .build();
    }
}

