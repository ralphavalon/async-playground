package com.example.demo.controller.request;

import java.util.List;

import lombok.Getter;

@Getter
public class CreateOrderRequest {

    private String userId;
    private List<ProductRequest> products;
    private PaymentRequest payment;
    
}
