package com.example.order.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("orders")
public class Order {
    @Id
    private Long id;
    private Long productId;
    private Integer quantity;
    private Integer totalPrice;
}