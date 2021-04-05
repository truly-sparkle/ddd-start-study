package me.yc.dddstudy.shop.catalog.infra.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import me.yc.dddstudy.shop.catalog.domain.category.CategoryId;
import me.yc.dddstudy.shop.catalog.domain.proudct.Product;
import me.yc.dddstudy.shop.catalog.domain.proudct.ProductId;
import me.yc.dddstudy.shop.catalog.domain.proudct.ProductRepository;
import org.springframework.stereotype.Repository;

@Repository
public class JpaProductRepository implements ProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Product product) {
        entityManager.persist(product);
    }

    @Override
    public Product findById(ProductId id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public void remove(Product product) {
        entityManager.remove(product);
    }

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = entityManager.createQuery(
            "select p from Product p order by p.id.id desc",
            Product.class);
        return query.getResultList();
    }

    @Override
    public List<Product> findByCategoryId(CategoryId categoryId, int page, int size) {
        TypedQuery<Product> query = entityManager.createQuery(
            "select p "
                + "from Product p "
                + "where :categoryId member of p.categoryIds "
                + "order by p.id.id desc",
            Product.class);
        query.setParameter("categoryId", categoryId);
        query.setFirstResult((page - 1) * size);
        query.setMaxResults(size);
        return query.getResultList();
    }

    @Override
    public long countsByCategoryId(CategoryId categoryId) {
        TypedQuery<Long> query = entityManager.createQuery(
            "select count(p) from Product p where :catId member of p.categoryIds",
            Long.class);
        query.setParameter("catId", categoryId);
        return query.getSingleResult().longValue();
    }
}
