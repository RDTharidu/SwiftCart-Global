package com.example.apigateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class SecurityFilter implements GlobalFilter, Ordered {

    // 1. API Key 
    private static final String API_KEY_HEADER = "x-api-key";
    private static final String VALID_API_KEY = "swiftcart-secret-key-123";

    // 2. Rate Limiting 
    private final Map<String, Integer> requestCounts = new ConcurrentHashMap<>();
    private final Map<String, Long> timeStamps = new ConcurrentHashMap<>();
    private static final int MAX_REQUESTS = 5;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String path = exchange.getRequest().getURI().getPath();

        
        if (!path.contains("/v3/api-docs") && !path.contains("/swagger-ui")) {
            
            // --- API KEY VALIDATION ---
            String apiKey = exchange.getRequest().getHeaders().getFirst(API_KEY_HEADER);
            if (apiKey == null || !apiKey.equals(VALID_API_KEY)) {
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED); // 401 Error
                return exchange.getResponse().setComplete();
            }

            // --- RATE LIMITING ---
            String ipAddress = exchange.getRequest().getRemoteAddress().getAddress().getHostAddress();
            long currentTime = System.currentTimeMillis();

            timeStamps.putIfAbsent(ipAddress, currentTime);
            requestCounts.putIfAbsent(ipAddress, 0);

            
            if (currentTime - timeStamps.get(ipAddress) > 10000) {
                timeStamps.put(ipAddress, currentTime);
                requestCounts.put(ipAddress, 0);
            }

            int currentRequests = requestCounts.get(ipAddress);
            if (currentRequests >= MAX_REQUESTS) {
                exchange.getResponse().setStatusCode(HttpStatus.TOO_MANY_REQUESTS); // 429 Error
                return exchange.getResponse().setComplete();
            }

            requestCounts.put(ipAddress, currentRequests + 1);
        }

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -1; 
    }
}