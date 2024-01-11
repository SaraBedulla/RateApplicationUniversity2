package com.project.rateuniapp.service;

import com.project.rateuniapp.dto.LoginDto;
import com.project.rateuniapp.dto.RegisterDto;

public interface AuthService {
    String register(RegisterDto registerDto);
    String login(LoginDto loginDto);

}
