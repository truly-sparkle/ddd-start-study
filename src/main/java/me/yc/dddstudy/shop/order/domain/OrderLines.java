package me.yc.dddstudy.shop.order.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import me.yc.dddstudy.common.model.Money;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderLines implements Serializable {
    @ElementCollection
    @CollectionTable(name = "order_line", joinColumns = @JoinColumn(name = "order_number"))
    @OrderColumn(name = "line_idx")
    private List<OrderLine> lines;

    public OrderLines(List<OrderLine> lines) {
        this.lines = lines;
    }

    public Money getTotalAmounts() {
        int sum = lines.stream()
            .mapToInt(o1 -> o1.getPrice().getValue() * o1.getQuantity())
            .sum();
        return new Money(sum);
    }

}
