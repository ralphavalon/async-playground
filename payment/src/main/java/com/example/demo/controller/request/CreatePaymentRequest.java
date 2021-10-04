package com.example.demo.controller.request;

import java.math.BigDecimal;

import lombok.Getter;

@Getter
public class CreatePaymentRequest {

    private String method;
    private BigDecimal amount;
    private String data;
    
}
