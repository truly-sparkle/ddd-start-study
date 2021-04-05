package me.yc.dddstudy.shop.order.domain;

import java.util.List;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.yc.dddstudy.common.model.Money;

@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

    @EmbeddedId
    private OrderNo orderId;
    private OrderState state;
    private ShippingInfo shippingInfo;
    private Money totalAmounts;
    private Orderer orderer;
    @Embedded
    private OrderLines orderLines;

    public void changeShippingInfo(ShippingInfo shippingInfo) {
        verifyNotYetShipped();
        setShippingInfo(shippingInfo);
    }

    public void changeOrderLines(List<OrderLine> newLines) {
        this.orderLines = new OrderLines(newLines);
        this.totalAmounts = this.orderLines.getTotalAmounts();
    }

    private void verifyNotYetShipped() {
        if (state != OrderState.PAYMENT_WAITING && state != OrderState.WAITING) {
            throw new IllegalStateException("Already Shipped!!");
        }
    }

    private void setShippingInfo(ShippingInfo shippingInfo) {
        if (shippingInfo == null) {
            throw new IllegalStateException("ShppingInfo is null!!");
        }
        this.shippingInfo = shippingInfo;
    }

    public void shipTo(ShippingInfo newShippingInfo) {

    }

}
