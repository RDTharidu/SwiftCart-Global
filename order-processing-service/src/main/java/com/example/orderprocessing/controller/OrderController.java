package com.example.orderprocessing.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    @GetMapping("/status")
    public String getStatus() {
        return "Order Processing Service එක සාර්ථකව වැඩ කරනවා! (Port 8083)";
    }
}