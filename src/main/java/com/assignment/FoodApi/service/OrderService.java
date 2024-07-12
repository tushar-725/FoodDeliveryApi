package com.assignment.FoodApi.service;

import com.assignment.FoodApi.model.Food;
import com.assignment.FoodApi.model.Order;
import com.assignment.FoodApi.model.OrderFood;
import com.assignment.FoodApi.repository.FoodRepository;
import com.assignment.FoodApi.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private FoodRepository foodRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public Order placeOrder(Order order) {
        for (OrderFood orderFood : order.getOrderFoods()) {
            // Fetch and set the Food entity
            orderFood.setFood(foodRepository.findById(orderFood.getFood().getId()).orElse(null));
            // Set the order for the OrderFood entity
            orderFood.setOrder(order);
        }
        return orderRepository.save(order);
    }

    public Order updatePaymentStatus(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found!"));
        order.setPaymentStatus("Paid");
        return orderRepository.save((order));
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
