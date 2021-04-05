package me.yc.dddstudy.shop.order.application;

import me.yc.dddstudy.shop.order.domain.OrderNo;
import me.yc.dddstudy.shop.order.domain.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class CancelOrderService {

    private OrderRepository orderRepository;

    public void cancel(OrderNo orderNo) {
    }

}
