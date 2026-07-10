package com.example.productcatalog; // මේක ඔයාගේ ෆයිල් එකේ තිබුණු නමමද බලන්න

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Security එක සම්පූර්ණයෙන්ම නිදි කරවන කෑල්ල මෙන්න
@SpringBootApplication(exclude = { 
    org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class 
})
public class ProductCatalogApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductCatalogApplication.class, args);
    }
}