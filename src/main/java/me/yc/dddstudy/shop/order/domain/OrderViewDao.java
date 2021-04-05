package me.yc.dddstudy.shop.order.domain;

import java.util.List;

public interface OrderViewDao {

    List<OrderView> selectByOrderer(String orderId);
}
