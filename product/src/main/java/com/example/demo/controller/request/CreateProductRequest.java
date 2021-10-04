package com.example.demo.controller.request;

import java.math.BigDecimal;

import lombok.Getter;

@Getter
public class CreateProductRequest {

    private String id;
    private String name;
    private BigDecimal price;
    private Integer quantityInStock;
    
}
