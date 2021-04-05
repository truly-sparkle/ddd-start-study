package me.yc.dddstudy.shop.catalog.application;

import me.yc.dddstudy.shop.member.domain.Customer;
import me.yc.dddstudy.common.model.Money;
import me.yc.dddstudy.shop.order.domain.OrderLines;

public interface RuleDiscounter {

    Money discount(Customer customer, OrderLines orderLines);
}
