package com.springboothexagonal.customer.infrastructure.adapters.repository;

import com.springboothexagonal.customer.domain.model.Customer;
import com.springboothexagonal.customer.domain.ports.out.CustomerRepositoryPort;
import com.springboothexagonal.customer.infrastructure.entities.model.SpringCustomer;
import com.springboothexagonal.customer.infrastructure.mapper.CustomerSpringDomainMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository("CustomerJPA")
@RequiredArgsConstructor
public class JpaCustomerRepositoryAdapter implements CustomerRepositoryPort {

    private final JpaCustomerRepository jpaCustomerRepository;
    private final CustomerSpringDomainMapper customerSpringDomainMapper;

    @Override
    public List<Customer> findAll() {

        List<Customer> customers = jpaCustomerRepository.findAll()
                .stream()
                .map(customerSpringDomainMapper::toCustomer)
                .collect(Collectors.toList());

        return customers;
    }

    @Override
    public Customer save(Customer customer) {

        SpringCustomer springCustomer = customerSpringDomainMapper.toSpringCustomer(customer);
        SpringCustomer savedSpringCustomer = jpaCustomerRepository.save(springCustomer);
        Customer savedCustomer = customerSpringDomainMapper.toCustomer(savedSpringCustomer);

        return savedCustomer;
    }

    @Override
    public Optional<Customer> findById(Long customerId) {
        return jpaCustomerRepository.findById(customerId)
                .map(customerSpringDomainMapper::toCustomer);
    }

    @Override
    public Optional<Customer> findByUuid(String customerUuid) {
        return jpaCustomerRepository.findByCustomerUuid(customerUuid)
                .map(customerSpringDomainMapper::toCustomer);
    }

    @Override
    public void deleteById(Long customerId) {
        jpaCustomerRepository.deleteById(customerId);
    }

    @Override
    public void deleteByUuid(String customerUuid) {
        jpaCustomerRepository.deleteByCustomerUuid(customerUuid);
    }

    @Override
    public boolean existsById(Long customerId) {
        return jpaCustomerRepository.existsById(customerId);
    }

    @Override
    public boolean existsByUuid(String customerUuid) {
        return jpaCustomerRepository.existsByCustomerUuid(customerUuid);
    }
}