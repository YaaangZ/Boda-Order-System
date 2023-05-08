package com.boda.order.Controller;

import com.boda.order.Model.Order;
import com.boda.order.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/orders")
    public String addOrder(@RequestBody Order order) {
        orderService.addOrder(order);
        return "redirect:/";
    }

    @GetMapping(value = "/orders/{orderId}", produces = "application/json")
    @ResponseBody
    public ResponseEntity<Order> getOrderById(@PathVariable String orderId) {
        Order order = orderService.findByOrderId(orderId);
        if (order == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(order, HttpStatus.OK);
        }
    }

    @GetMapping("/orders")
    @ResponseBody
    public List<Order> getAllOrders() {
        List<Order> orders = orderService.findAll();
        return orders;
    }
}
