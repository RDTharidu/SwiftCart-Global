package com.example.notification.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notifications")
public class NotificationController {

    @GetMapping("/status")
    public String getStatus() {
        return "Notification Service එක සාර්ථකව වැඩ කරනවා! (Port 8085)";
    }
}