package com.springboothexagonal.customer.application.service;

import com.springboothexagonal.customer.application.mapper.dto.CustomerDTOMapper;
import com.springboothexagonal.customer.application.mapper.request.CustomerAddRequestMapper;
import com.springboothexagonal.customer.domain.dto.CustomerDTO;
import com.springboothexagonal.customer.domain.model.Customer;
import com.springboothexagonal.customer.domain.ports.in.CustomerUseCases;
import com.springboothexagonal.customer.domain.request.CustomerAddRequest;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
public class CustomerService {

    private final CustomerUseCases customerUseCases;
    private final CustomerDTOMapper customerDTOMapper;
    private final CustomerAddRequestMapper customerAddRequestMapper;

    public CustomerService(
            CustomerUseCases customerUseCases,
            CustomerDTOMapper customerDTOMapper,
            CustomerAddRequestMapper customerAddRequestMapper
    ) {
        this.customerUseCases = customerUseCases;
        this.customerDTOMapper = customerDTOMapper;
        this.customerAddRequestMapper = customerAddRequestMapper;
    }

    public List<CustomerDTO> getAllCustomers(){

        List<CustomerDTO> customers = customerUseCases.selectAllCustomers()
                .stream()
                .map(customerDTOMapper::toCustomerDTO)
                .collect(Collectors.toList());

        return customers;
    }

    public boolean addCustomer(CustomerAddRequest customerAddRequest){

        Customer customer = customerAddRequestMapper.toCustomer(customerAddRequest);
        Customer savedCustomer = customerUseCases.insertCustomer(customer);

        if(savedCustomer != null && savedCustomer.getCustomerId() != null){

            return true;
        }
        else{
            throw new RuntimeException("Server error adding Customer");
        }
    }

    public Optional<CustomerDTO> getCustomer(String customerUuid){

        Optional<CustomerDTO> customer = customerUseCases.selectCustomerByUuid(customerUuid)
                .map(customerDTOMapper::toCustomerDTO);

        if(customer.isPresent()){
            return customer;
        }
        else{
            throw new RuntimeException("Server error fetching data");
        }
    }

    public boolean deleteCustomer(String customerUuid){

        boolean existsCustomer = customerUseCases.existsCustomerByUuid(customerUuid);

        if(existsCustomer){

            customerUseCases.deleteCustomerByUuid(customerUuid);

            boolean stillExistsCustomer = customerUseCases.existsCustomerByUuid(customerUuid);

            if(!stillExistsCustomer){
                return true;
            }
            else{
                throw new RuntimeException("Server error deleting Customer");
            }
        }
        else{
            throw new RuntimeException("Customer does not exist");
        }
    }
}