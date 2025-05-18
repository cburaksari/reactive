package com.example.order.service;

import com.example.order.model.Order;
import com.example.order.model.ProductResponse;
import com.example.order.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final WebClient productWebClient;

    public OrderService(OrderRepository orderRepository, WebClient productWebClient) {
        this.orderRepository = orderRepository;
        this.productWebClient = productWebClient;
    }

    public Mono<Order> createOrder(Order order) {
        return productWebClient
                .get()
                .uri("/products/{id}", order.getProductId())
                .retrieve()
                .bodyToMono(ProductResponse.class)
                .flatMap(product -> {
                    Order result = new Order();
                    result.setProductId(product.getId());
                    result.setQuantity(order.getQuantity());
                    result.setTotalPrice(order.getTotalPrice());
                    return orderRepository.save(result);
                });
    }

    public Mono<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public Flux<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Mono<Boolean> deleteOrder(Long id) {
        return orderRepository.existsById(id)
            .filter(Boolean::booleanValue)
            .flatMap(exists -> orderRepository.deleteById(id).thenReturn(true))
            .defaultIfEmpty(false);
    }
}