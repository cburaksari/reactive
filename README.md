# Reactive Microservices System with API Gateway, Rate Limiting, and Prometheus Monitoring

This project demonstrates a basic reactive microservices architecture built with **Spring Boot WebFlux**, an **API Gateway**, and observability using **Prometheus** and **Grafana**.

---

## 🧱 Architecture Overview

```plaintext
                    +-------------------+
                    |    React Frontend |
                    +---------+---------+
                              |
                              v
                    +---------+---------+
                    |     API Gateway   |  ← Spring Cloud Gateway
                    +---------+---------+
                              |
             +----------------+----------------+
             |                                 |
             v                                 v
    +----------------+               +------------------+
    | product-service |               |  order-service   |
    +----------------+               +------------------+
