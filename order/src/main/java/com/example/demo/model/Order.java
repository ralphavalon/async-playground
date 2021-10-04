package com.example.demo.model;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Order {
    
    @Id
    private String id;
    private String userId;
    private String status;
    private BigDecimal total;
    private List<Product> products;
    private Payment payment;

}
