package com.springboothexagonal.customer.domain.model;

import java.util.UUID;

public class Customer {

    private Long customerId;
    private String customerUuid = UUID.randomUUID().toString();
    private String name;
    private String lastName;
    private String email;

    public Customer() {
    }

    public Customer(
            Long customerId,
            String customerUuid,
            String name,
            String lastName,
            String email) {
        this.customerId = customerId;
        this.customerUuid = customerUuid;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }

    public Customer(
            String name,
            String lastName,
            String email
    ) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerUuid() {
        return customerUuid;
    }

    public void setCustomerUuid(String customerUuid) {
        this.customerUuid = customerUuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}