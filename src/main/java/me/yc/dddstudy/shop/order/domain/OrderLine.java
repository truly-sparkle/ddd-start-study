package me.yc.dddstudy.shop.order.domain;

import javax.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import me.yc.dddstudy.common.model.Money;
import me.yc.dddstudy.shop.catalog.domain.proudct.ProductId;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderLine {

    @Embedded
    private ProductId productId;

    @Column(name = "price")
    private Money price;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "amounts")
    private Money amounts;

    public OrderLine(ProductId productId, Money price, int quantity) {
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
        this.amounts = calculateAmounts();
    }

    private Money calculateAmounts() {
        return price.multiply(quantity);
    }

    public ProductId getProductId() {
        return productId;
    }

    public Money getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public Money getAmounts() {
        return amounts;
    }
}
