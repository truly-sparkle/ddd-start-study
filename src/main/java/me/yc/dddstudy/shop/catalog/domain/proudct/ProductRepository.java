package me.yc.dddstudy.shop.catalog.domain.proudct;

import java.util.List;
import me.yc.dddstudy.shop.catalog.domain.category.CategoryId;

public interface ProductRepository {
    void save(Product product);

    Product findById(ProductId id);

    void remove(Product product);

    List<Product> findAll();

    List<Product> findByCategoryId(CategoryId categoryId, int page, int size);

    long countsByCategoryId(CategoryId categoryId);
}
