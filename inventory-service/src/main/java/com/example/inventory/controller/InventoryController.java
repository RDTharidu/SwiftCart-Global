package com.example.inventory.controller;

import com.example.inventory.entity.Inventory;
import com.example.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    // POST: අලුත් තොගයක් ඇතුළත් කරන්න (Update Stock)
    @PostMapping("/update")
    public ResponseEntity<Inventory> updateStock(@RequestBody Inventory inventory) {
        return ResponseEntity.ok(inventoryService.updateStock(inventory));
    }

    // GET: බඩු තියෙනවද කියලා චෙක් කරන්න
    @GetMapping("/check")
    public ResponseEntity<Boolean> checkStock(
            @RequestParam Long productId, 
            @RequestParam Integer quantity) {
        return ResponseEntity.ok(inventoryService.checkInStock(productId, quantity));
    }
}