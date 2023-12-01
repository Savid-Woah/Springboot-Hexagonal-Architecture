package com.springboothexagonal.customer.application.mapper.dto;

import com.springboothexagonal.customer.domain.dto.CustomerDTO;
import com.springboothexagonal.customer.domain.model.Customer;
import com.springboothexagonal.customer.infrastructure.entities.dto.SpringCustomerDTO;

public class CustomerDTOMapper {

    public CustomerDTO toCustomerDTO(Customer customer){

        return new CustomerDTO(

                customer.getCustomerUuid(),
                customer.getName(),
                customer.getLastName(),
                customer.getEmail()
        );
    }

    public SpringCustomerDTO toSpringCustomerDTO(CustomerDTO customerDTO){

        return new SpringCustomerDTO(

                customerDTO.customerUuid(),
                customerDTO.name(),
                customerDTO.lastName(),
                customerDTO.email()
        );
    }
}