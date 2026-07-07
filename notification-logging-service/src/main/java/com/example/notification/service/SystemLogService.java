package com.example.notification.service;

import com.example.notification.entity.SystemLog;
import com.example.notification.repository.SystemLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class SystemLogService {

    @Autowired
    private SystemLogRepository systemLogRepository;

    public SystemLog saveLog(SystemLog systemLog) {
        systemLog.setTimestamp(LocalDateTime.now());
        return systemLogRepository.save(systemLog);
    }
}