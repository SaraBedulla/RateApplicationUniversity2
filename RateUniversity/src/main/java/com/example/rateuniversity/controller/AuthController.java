package com.project.rateuniapp.controller;

import lombok.AllArgsConstructor;
import com.project.rateuniapp.dto.LoginDto;
import com.project.rateuniapp.dto.RegisterDto;
import com.project.rateuniapp.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;

    //build register rest api
    @PostMapping("/register")
    public ResponseEntity<String> register (@RequestBody RegisterDto registerDto){
        String response = authService.register(registerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    //build login rest api
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
        String response = authService.login(loginDto);
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }

}

