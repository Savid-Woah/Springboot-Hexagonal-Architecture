package com.springboothexagonal.customer.application.mapper.request;

import com.springboothexagonal.customer.domain.model.Customer;
import com.springboothexagonal.customer.domain.request.CustomerAddRequest;
import com.springboothexagonal.customer.infrastructure.entities.request.SpringCustomerAddRequest;

public class CustomerAddRequestMapper {

    public CustomerAddRequest toCustomerAddRequest(SpringCustomerAddRequest springCustomerAddRequest){

        return new CustomerAddRequest(

                springCustomerAddRequest.getName(),
                springCustomerAddRequest.getLastName(),
                springCustomerAddRequest.getEmail()
        );
    }

    public Customer toCustomer(CustomerAddRequest customerAddRequest){

        return new Customer(

                customerAddRequest.getEmail(),
                customerAddRequest.getName(),
                customerAddRequest.getEmail()
        );
    }
}