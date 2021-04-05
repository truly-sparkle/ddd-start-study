package me.yc.dddstudy.shop.order.application;

import lombok.Getter;
import me.yc.dddstudy.shop.order.domain.ShippingInfo;

@Getter
public class ChangeShippingRequest {

    private String number;
    private ShippingInfo shippingInfo;

    public ChangeShippingRequest(String number, ShippingInfo shippingInfo) {
        this.number = number;
        this.shippingInfo = shippingInfo;
    }
}
