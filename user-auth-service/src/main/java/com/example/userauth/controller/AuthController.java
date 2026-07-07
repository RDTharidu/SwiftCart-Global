package com.example.userauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @GetMapping("/status")
    public String getStatus() {
        return "User & Auth Service එක සාර්ථකව වැඩ කරනවා! (Port 8081)";
    }
}