package com.springboothexagonal.customer.infrastructure.entities.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record SpringCustomerDTO(

        String customerUuid,
        String name,
        String lastName,
        String email
) {
}