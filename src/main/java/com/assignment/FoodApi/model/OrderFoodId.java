package com.assignment.FoodApi.model;

import java.io.Serializable;
import java.util.Objects;

public class OrderFoodId implements Serializable {

    private Long order;
    private Long food;

    public OrderFoodId() {

    }

    public OrderFoodId(Long order, Long food) {
        this.order = order;
        this.food = food;
    }

    public Long getOrder() {
        return order;
    }

    public void setOrder(Long order) {
        this.order = order;
    }

    public Long getFood() {
        return food;
    }

    public void setFood(Long food) {
        this.food = food;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderFoodId that = (OrderFoodId) o;
        return Objects.equals(order, that.order) && Objects.equals(food, that.food);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, food);
    }
}
