package com.example.product.service;

import com.example.product.model.Product;
import com.example.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Mono<Product> createProduct(Product product) {
        return productRepository.save(product);
    }

    public Flux<Product> getAllProducts() {
        // simulate slow process to examine prometheus metrics
        return productRepository.findAll().delaySubscription(Duration.ofMillis(500));
    }

    public Mono<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Mono<Boolean> deleteProduct(Long id) {
        return productRepository.existsById(id).filter(Boolean::booleanValue).flatMap(exists -> productRepository.deleteById(id).thenReturn(true)).defaultIfEmpty(false);
    }
}