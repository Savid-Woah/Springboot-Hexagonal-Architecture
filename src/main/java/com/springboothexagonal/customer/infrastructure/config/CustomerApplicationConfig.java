package com.springboothexagonal.customer.infrastructure.config;

import com.springboothexagonal.customer.application.mapper.dto.CustomerDTOMapper;
import com.springboothexagonal.customer.application.mapper.request.CustomerAddRequestMapper;
import com.springboothexagonal.customer.application.service.CustomerService;
import com.springboothexagonal.customer.application.usecase.CustomerUseCaseImpl;
import com.springboothexagonal.customer.domain.ports.out.CustomerRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerApplicationConfig {

    @Bean
    public CustomerService customerService(
            CustomerRepositoryPort customerRepositoryPort
    ){

        return new CustomerService(

                new CustomerUseCaseImpl(customerRepositoryPort),
                new CustomerDTOMapper(),
                new CustomerAddRequestMapper()
        );
    }

    @Bean
    public CustomerDTOMapper customerDTOMapper(){return new CustomerDTOMapper();}

    @Bean
    public CustomerAddRequestMapper customerAddRequestMapper(){return new CustomerAddRequestMapper();}
}