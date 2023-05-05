package com.boda.order.Controller;

import com.boda.order.Model.Order;
import com.boda.order.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/orders")
    public String addOrder(@RequestBody Order order) {
        orderService.addOrder(order);
        return "redirect:/";
    }
}
