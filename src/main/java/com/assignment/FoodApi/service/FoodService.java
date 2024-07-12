package com.assignment.FoodApi.service;

import com.assignment.FoodApi.model.Food;
import com.assignment.FoodApi.repository.FoodRepository;
import com.assignment.FoodApi.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    public List<Food> getAllFoods() {
        return foodRepository.findAll();
    }

    public Optional<Food> getFoodById(Long id) {
        return foodRepository.findById(id);
    }

    public Food createFood(Food food) {
        return foodRepository.save(food);
    }

    public Food updateFood(Long id, Food food) {
        Food f = foodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Food not found!"));
        f.setName(food.getName());
        f.setPrice(food.getPrice());
        f.setRestaurant(food.getRestaurant());
        return foodRepository.save((f));
    }

    public void deleteFood(Long id) {
        foodRepository.deleteById(id);
    }
}
