package com.example.productcatalog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @GetMapping("/status")
    public String getStatus() {
        return "Product Catalog Service එක සාර්ථකව වැඩ කරනවා! (Port 8082)";
    }
}