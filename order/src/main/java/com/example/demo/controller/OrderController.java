package com.example.demo.controller;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.stream.Collectors;

import com.example.demo.controller.request.CreateOrderRequest;
import com.example.demo.model.Order;
import com.example.demo.model.Payment;
import com.example.demo.model.Product;
import com.example.demo.persistence.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository repository;

    @PostMapping
    public Mono<Order> createOrder(@RequestBody @Validated CreateOrderRequest request) {
        // do your async code
        return repository.save(Order.builder()
                    .id(UUID.randomUUID().toString())
                    .payment(Payment.builder()
                            .id(UUID.randomUUID().toString())
                            .method(request.getPayment().getMethod())
                            .amount(new BigDecimal("200.10"))
                            .status("PAID")
                            .build())
                    .products(request.getProducts().stream().map(p -> Product.builder()
                                                                .id(p.getId())
                                                                .name("Random")
                                                                .quantity(p.getQuantity())
                                                                .price(new BigDecimal("20.50"))
                                                                .build()).collect(Collectors.toList()))
                    .status("PAID")
                    .total(new BigDecimal("200.10"))
                    .userId(request.getUserId())
                    .build());
    }
    
}
