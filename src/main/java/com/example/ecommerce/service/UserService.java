package com.example.ecommerce.service;



import com.example.ecommerce.model.Users;
import com.example.ecommerce.repository.UserJpaRepository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.AuthenticationException;

@Service
public class UserService {

    @Autowired
    private JWTService jwtService;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    private UserJpaRepository repo;


    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public Users register(Users user) {
        user.setPassword(encoder.encode(user.getPassword()));
        repo.save(user);
        return user;
    }

    public ResponseEntity<Map<String, String>> verify(Users user) {
        Map<String, String> response = new HashMap<>();
        try {
            // Attempting authentication
            Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
            );
    
            // If authentication is successful
            if (authentication.isAuthenticated()) {
                String token = jwtService.generateToken(user.getUsername());
                System.out.print(token);
                System.out.println(user.getUsername());
                response.put("jwt_token", token);
                return ResponseEntity.ok(response);
            }
    
        } catch (AuthenticationException ex) {
            // Handling failed authentication
            // response.put("error", "Wrong credentials");
            response.put("message", "Invalid username or password");
            return ResponseEntity.status(401).body(response);
        }
    
        // Fallback response (just in case)
        response.put("error", "Authentication failed unexpectedly");
        return ResponseEntity.status(401).body(response);
    
}

    public Users findByUsername(String userName) {
        return repo.findByUsername(userName);
    }
}