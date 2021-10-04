package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.controller.request.CreateProductRequest;
import com.example.demo.model.Product;
import com.example.demo.persistence.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @PostMapping
    public Mono<Product> createProduct(@RequestBody @Validated CreateProductRequest request) {
        return repository.save(Product.builder()
                .id(request.getId())
                .name(request.getName())
                .quantityInStock(request.getQuantityInStock())
                .price(request.getPrice())
                .build());
    }
    
}
