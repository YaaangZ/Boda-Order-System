package com.boda.order.Service;

import com.boda.order.Model.Order;
import com.boda.order.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    public void addOrder(Order order) {
        orderRepository.save(order);
    }

    @Transactional(readOnly = true)
    public Order findByOrderId(String orderId) {
        return orderRepository.findByOrderId(orderId);
    }

    @Transactional(readOnly = true)
    public List<Order> findAll() {
        return orderRepository.findAll();
    }
}
