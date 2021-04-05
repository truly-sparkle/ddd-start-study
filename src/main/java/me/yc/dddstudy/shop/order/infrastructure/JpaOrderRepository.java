package me.yc.dddstudy.shop.order.infrastructure;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import me.yc.dddstudy.shop.order.domain.Order;
import me.yc.dddstudy.shop.order.domain.OrderNo;
import me.yc.dddstudy.shop.order.domain.OrderRepository;
import org.springframework.stereotype.Repository;

@Repository
public class JpaOrderRepository implements OrderRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Order findById(OrderNo id) {
        return em.find(Order.class, id);
    }

    @Override
    public void save(Order order) {
        em.persist(order);
    }
}
