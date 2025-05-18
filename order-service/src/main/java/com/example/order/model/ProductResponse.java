package com.example.order.model;

import lombok.Data;

@Data
public class ProductResponse {
    private Long id;
    private String name;
    private Integer price;
}