package com.springboothexagonal.customer.domain.dto;

public record CustomerDTO(

        String customerUuid,
        String name,
        String lastName,
        String email
) {
}