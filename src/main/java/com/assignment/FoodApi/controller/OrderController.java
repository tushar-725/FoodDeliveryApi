package com.assignment.FoodApi.controller;

import com.assignment.FoodApi.model.Order;
import com.assignment.FoodApi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id)
                .orElseThrow(() -> new RuntimeException("Order not found!"));
    }

    @PostMapping("/create")
    public Order placeOrder(@RequestBody Order order) {
        return orderService.placeOrder(order);
    }

    @PatchMapping("/{id}")
    public Order updatePaymentStatus(@PathVariable Long id) {
        return orderService.updatePaymentStatus(id);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.getOrderById(id)
                .orElseThrow(() -> new RuntimeException("Order not found!"));
        orderService.deleteOrder(id);
    }
}
