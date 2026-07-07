package com.example.inventory.service;

import com.example.inventory.entity.Inventory;
import com.example.inventory.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    // තොගය අලුතින් දාන්න හරි අප්ඩේට් කරන්න හරි
    public Inventory updateStock(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    // ඉල්ලන ප්‍රමාණයට බඩු ස්ටොක් එකේ තියෙනවද කියලා චෙක් කරන්න
    public boolean checkInStock(Long productId, Integer requiredQuantity) {
        return inventoryRepository.findByProductId(productId)
                .map(inv -> inv.getQuantity() >= requiredQuantity)
                .orElse(false);
    }
}