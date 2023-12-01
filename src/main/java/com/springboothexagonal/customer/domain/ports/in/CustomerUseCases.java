package com.springboothexagonal.customer.domain.ports.in;

import com.springboothexagonal.customer.domain.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerUseCases {

    List<Customer> selectAllCustomers();
    Customer insertCustomer(Customer customer);
    Optional<Customer> selectCustomerById(Long customerId);
    Optional<Customer> selectCustomerByUuid(String customerUuid);
    void deleteCustomerById(Long customerId);
    void deleteCustomerByUuid(String customerUuid);
    boolean existsCustomerById(Long customerId);
    boolean existsCustomerByUuid(String customerUuid);
}