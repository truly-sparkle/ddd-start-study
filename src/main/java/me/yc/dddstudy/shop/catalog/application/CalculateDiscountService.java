package me.yc.dddstudy.shop.catalog.application;

import lombok.RequiredArgsConstructor;
import me.yc.dddstudy.shop.member.domain.Customer;
import me.yc.dddstudy.shop.member.domain.Customer.CustomerId;
import me.yc.dddstudy.shop.member.domain.CustomerRepository;
import me.yc.dddstudy.common.model.Money;
import me.yc.dddstudy.shop.order.domain.OrderLines;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalculateDiscountService {

    private final CustomerRepository customerRepository;
    private final RuleDiscounter ruleDiscounter;

    public Money calculateDiscount(OrderLines orderLines, CustomerId customerId) {
        Customer customer = findCustomer(customerId);
        return ruleDiscounter.discount(customer, orderLines);
    }

    public Customer findCustomer(CustomerId customerId) {
        return customerRepository.findById(customerId)
            .orElseThrow(NoCustomerException::new);
    }
}
