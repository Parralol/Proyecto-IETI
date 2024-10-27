package com.proyecto.ieti.pemc.controller;

import com.proyecto.ieti.pemc.entity.User;
import com.proyecto.ieti.pemc.security.JwtUtil;
import com.proyecto.ieti.pemc.service.UserService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/v1/authenticate/")
public class AuthController {


    @Autowired
    private UserService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;


    @PostMapping
    public ResponseEntity<String> login(@RequestBody AuthRequest loginDto) throws Exception {
        
        Optional<User> xf = Optional.ofNullable(userDetailsService.findByEmail(loginDto.getUsername()));
        if(xf.isPresent() && BCrypt.checkpw(loginDto.getPassword(), xf.get().getPasswordHash())){
            return ResponseEntity.ok(jwtUtil.generateToken(loginDto.getUsername()));
        }else{   
            throw new Exception( loginDto.getPassword() + "---" + xf.get().getPasswordHash() + BCrypt.checkpw(loginDto.getPassword(), xf.get().getPasswordHash()));
        }
        
    }
}


class AuthRequest {
    private final String username;
    private final String password;


    public AuthRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
