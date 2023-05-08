package com.boda.order.Repository;

import com.boda.order.Model.Order;

import java.util.List;

public interface OrderRepository {
    void save(Order order);
    Order findByOrderId(String orderId);
    List<Order> findAll();
}
