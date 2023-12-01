package com.springboothexagonal.customer.infrastructure.entities.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SpringCustomerAddRequest {

    @NotNull(message = "Field required")
    private String name;
    @NotNull(message = "Field required")
    private String lastName;
    @NotNull(message = "Field required")
    private String email;
}