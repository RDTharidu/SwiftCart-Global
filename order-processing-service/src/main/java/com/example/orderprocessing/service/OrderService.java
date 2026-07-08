package com.example.orderprocessing.service;

import com.example.orderprocessing.entity.Order;
import com.example.orderprocessing.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private EmailService emailService;

    // අලුත් ඕඩර් එකක් දාන Method එක
    public Order placeOrder(Order order) {
        // මුලින්ම ඕඩර් එක දාද්දී තත්ත්වය "PENDING" විදිහට සෙට් කරනවා
        order.setStatus("PENDING");
        Order savedOrder = orderRepository.save(order);
        
        // 🚀 EXTRA FEATURE: Database එකට සේව් වුණාට පස්සේ කස්ටමර්ට Email එක යවනවා
        if (savedOrder.getCustomerEmail() != null && !savedOrder.getCustomerEmail().isEmpty()) {
            emailService.sendOrderConfirmation(savedOrder.getCustomerEmail(), savedOrder.getId(), savedOrder.getStatus());
        }
        
        return savedOrder;
    }
}