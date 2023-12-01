package com.springboothexagonal.task.domain.entities.dto;

public record TaskDTO(

        String taskUuid,
        String title,
        String description
) {
}
