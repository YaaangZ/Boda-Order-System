package com.boda.order.Repository;

import com.boda.order.Model.Order;

public interface OrderRepository {
    void save(Order order);
    Order findByOrderId(Long orderId);
}
