package com.proyecto.ieti.pemc.controller;

import com.proyecto.ieti.pemc.entity.User;
import com.proyecto.ieti.pemc.security.JwtUtil;
import com.proyecto.ieti.pemc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000/login")
@RequestMapping("/v1/authenticate/")
public class AuthController {

    @Autowired
    private UserService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Map<String, String>> login(@RequestBody AuthRequest loginDto) throws Exception {
        Optional<User> xf = Optional.ofNullable(userDetailsService.findByEmail(loginDto.getUsername()));
        if (xf.isPresent() && BCrypt.checkpw(loginDto.getPassword(), xf.get().getPasswordHash())) {
            String token = jwtUtil.generateToken(loginDto.getUsername());
            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            return ResponseEntity.ok(response); // Devuelve el token en un JSON
        } else {
            throw new Exception("Credenciales inválidas");
        }
    }

}


// Clase para la solicitud de autenticación
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

// Clase para la respuesta de autenticación
class AuthResponse {
    private final String token;

    public AuthResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
