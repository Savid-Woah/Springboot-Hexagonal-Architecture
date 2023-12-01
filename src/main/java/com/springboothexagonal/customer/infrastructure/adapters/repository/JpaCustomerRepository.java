package com.springboothexagonal.customer.infrastructure.adapters.repository;

import com.springboothexagonal.customer.infrastructure.entities.model.SpringCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaCustomerRepository extends JpaRepository<SpringCustomer, Long> {
    Optional<SpringCustomer> findByCustomerUuid(String customerUuid);
    void deleteByCustomerUuid(String customerUuid);
    boolean existsByCustomerUuid(String customerUuid);
}