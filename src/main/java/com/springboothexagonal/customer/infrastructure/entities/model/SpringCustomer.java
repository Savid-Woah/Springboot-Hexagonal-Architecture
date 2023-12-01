package com.springboothexagonal.customer.infrastructure.entities.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Customer")
@Table(name = "customers")
public class SpringCustomer {

    @Id
    @GeneratedValue
    @Column(name = "customer_id", updatable = false, nullable = false)
    private Long customerId;

    @Column(name = "customer_uuid", updatable = false, nullable = false)
    private String customerUuid;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;
}