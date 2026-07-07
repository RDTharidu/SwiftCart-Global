package com.example.orderprocessing.service;

import com.example.orderprocessing.entity.Order;
import com.example.orderprocessing.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    
    public Order placeOrder(Order order) {
        
        order.setStatus("PENDING");
        return orderRepository.save(order);
    }
}