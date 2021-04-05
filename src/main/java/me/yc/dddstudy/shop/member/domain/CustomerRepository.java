package me.yc.dddstudy.shop.member.domain;


import java.util.Optional;
import me.yc.dddstudy.shop.member.domain.Customer.CustomerId;

public interface CustomerRepository {

    Optional<Customer> findById(CustomerId customerId);
}
