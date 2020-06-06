package com.example.demo.order;

import java.util.Optional;

public interface OrderRepository {
    Optional<Order> findById(long orderId);
}
