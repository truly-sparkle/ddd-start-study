package me.yc.dddstudy.shop.order.domain;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

public class JpaOrderViewDao implements OrderViewDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<OrderView> selectByOrderer(String ordererId) {
        String selectQuery =
            "select new me.yc.dddstudy.shop.order.domain.OrderView(o, m, p) "
                + "from Order o "
                + "join o.orderLines o1, Member m, Product p "
                + "where o.orderer.memberId.id = :ordererId "
                + "and o.orderer.memberId = m.id "
                + "and index(o1) = 0 "
                + "and o1.productId = p.id "
                + "order by o.number.number desc";
        TypedQuery<OrderView> query =
            em.createQuery(selectQuery,OrderView.class);
        query.setParameter("ordererId", ordererId);
        return query.getResultList();
    }
}
