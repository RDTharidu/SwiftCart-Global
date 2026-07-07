package com.example.notification.controller;

import com.example.notification.entity.SystemLog;
import com.example.notification.service.SystemLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/logs")
public class SystemLogController {

    @Autowired
    private SystemLogService systemLogService;

    @PostMapping
    public ResponseEntity<SystemLog> createLog(@RequestBody SystemLog systemLog) {
        return ResponseEntity.ok(systemLogService.saveLog(systemLog));
    }
}