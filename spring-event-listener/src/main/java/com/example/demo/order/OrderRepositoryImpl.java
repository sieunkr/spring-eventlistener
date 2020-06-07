package com.example.demo.order;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    @Override
    public Optional<Order> findById(long orderId) {
        //TODO: 구현
        return Optional.ofNullable(null);
    }
}
