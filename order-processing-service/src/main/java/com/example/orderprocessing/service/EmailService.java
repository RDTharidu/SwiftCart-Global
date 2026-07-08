package com.example.orderprocessing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendOrderConfirmation(String toEmail, Long orderId, String status) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("swiftcart@gmail.com");
            message.setTo(toEmail);
            message.setSubject("🎉 SwiftCart Global - Order Confirmation (Order #" + orderId + ")");
            message.setText("Dear Customer,\n\nYour order (ID: " + orderId + ") has been placed successfully in our system.\n\nCurrent Status: " + status + "\n\nThank you for shopping with SwiftCart Global!");
            
            mailSender.send(message);
            System.out.println("✅ Email sent successfully to: " + toEmail);
        } catch (Exception e) {
            System.out.println("⚠️ Email feature triggered, but not sent (Configure Gmail App Password to activate): " + e.getMessage());
        }
    }
}