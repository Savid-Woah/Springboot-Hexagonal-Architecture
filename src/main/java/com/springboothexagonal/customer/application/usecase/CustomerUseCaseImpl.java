package com.springboothexagonal.customer.application.usecase;

import com.springboothexagonal.customer.domain.model.Customer;
import com.springboothexagonal.customer.domain.ports.in.CustomerUseCases;
import com.springboothexagonal.customer.domain.ports.out.CustomerRepositoryPort;

import java.util.List;
import java.util.Optional;

public class CustomerUseCaseImpl implements CustomerUseCases {

    private final CustomerRepositoryPort customerRepositoryPort;

    public CustomerUseCaseImpl(CustomerRepositoryPort customerRepositoryPort) {
        this.customerRepositoryPort = customerRepositoryPort;
    }

    @Override
    public List<Customer> selectAllCustomers() {
        return customerRepositoryPort.findAll();
    }

    @Override
    public Customer insertCustomer(Customer customer) {
        return customerRepositoryPort.save(customer);
    }

    @Override
    public Optional<Customer> selectCustomerById(Long customerId) {
        return customerRepositoryPort.findById(customerId);
    }

    @Override
    public Optional<Customer> selectCustomerByUuid(String customerUuid) {
        return customerRepositoryPort.findByUuid(customerUuid);
    }

    @Override
    public void deleteCustomerById(Long customerId) {
        customerRepositoryPort.deleteById(customerId);
    }

    @Override
    public void deleteCustomerByUuid(String customerUuid) {
        customerRepositoryPort.deleteByUuid(customerUuid);
    }

    @Override
    public boolean existsCustomerById(Long customerId) {
        return customerRepositoryPort.existsById(customerId);
    }

    @Override
    public boolean existsCustomerByUuid(String customerUuid) {
        return customerRepositoryPort.existsByUuid(customerUuid);
    }
}