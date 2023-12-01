package com.springboothexagonal.customer.infrastructure.mapper;

import com.springboothexagonal.customer.domain.model.Customer;
import com.springboothexagonal.customer.infrastructure.entities.model.SpringCustomer;
import org.springframework.stereotype.Component;

@Component
public class CustomerSpringDomainMapper {

    public Customer toCustomer(SpringCustomer springCustomer){

        return new Customer(

                springCustomer.getCustomerId(),
                springCustomer.getCustomerUuid(),
                springCustomer.getName(),
                springCustomer.getLastName(),
                springCustomer.getEmail()
        );
    }

    public SpringCustomer toSpringCustomer(Customer customer){
        return new SpringCustomer(

                customer.getCustomerId(),
                customer.getCustomerUuid(),
                customer.getName(),
                customer.getLastName(),
                customer.getEmail()
        );
    }
}