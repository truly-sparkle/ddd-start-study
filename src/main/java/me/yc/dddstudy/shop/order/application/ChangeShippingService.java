package me.yc.dddstudy.shop.order.application;

import lombok.RequiredArgsConstructor;
import me.yc.dddstudy.shop.order.domain.Order;
import me.yc.dddstudy.shop.order.domain.OrderNo;
import me.yc.dddstudy.shop.order.domain.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ChangeShippingService {

    private final OrderRepository orderRepository;

    @Transactional
    public void changeShipping(ChangeShippingRequest changeReq) {
        Order order = orderRepository.findById(new OrderNo(changeReq.getNumber()));
        checkNoOrder(order);
        order.changeShippingInfo(changeReq.getShippingInfo());
    }

    private void checkNoOrder(Order order) {
        if (order == null) {
            throw new NoOrderException();
        }
    }

}
