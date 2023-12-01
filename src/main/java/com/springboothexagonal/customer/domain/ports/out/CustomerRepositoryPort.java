package com.springboothexagonal.customer.domain.ports.out;

import com.springboothexagonal.customer.domain.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepositoryPort {
    List<Customer> findAll();
    Customer save(Customer customer);
    Optional<Customer> findById(Long customerId);
    Optional<Customer> findByUuid(String customerUuid);
    void deleteById(Long customerId);
    void deleteByUuid(String customerUuid);
    boolean existsById(Long customerId);
    boolean existsByUuid(String customerUuid);
}