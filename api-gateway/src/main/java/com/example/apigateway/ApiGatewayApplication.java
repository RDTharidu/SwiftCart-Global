package com.example.apigateway; // ඔයාගේ පැකේජ් නම මේක නෙවෙයි නම් ඒක විතරක් වෙනස් කරන්න

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Gateway එකෙත් Security අයින් කරනවා නම් මේක දාන්න
@SpringBootApplication(exclude = { 
    org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
    org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration.class
})
public class ApiGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }
}