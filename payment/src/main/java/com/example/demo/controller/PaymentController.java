package com.example.demo.controller;

import java.util.UUID;

import com.example.demo.controller.request.CreatePaymentRequest;
import com.example.demo.model.Payment;
import com.example.demo.persistence.PaymentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentRepository repository;

    @PostMapping
    public Mono<Payment> createProduct(@RequestBody @Validated CreatePaymentRequest request) {
        return repository.save(Payment.builder()
                .id(UUID.randomUUID().toString())
                .method(request.getMethod())
                .amount(request.getAmount())
                .status("PAID")
                .build());
    }
    
}
