package com.springboothexagonal.task.infrastructure.entities.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record SpringTaskDTO(

        String taskUuid,
        String title,
        String description
) {
}