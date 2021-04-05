package me.yc.dddstudy.shop.order.domain;

public interface OrderRepository {

    Order findById(OrderNo id);

    void save(Order order);
}
