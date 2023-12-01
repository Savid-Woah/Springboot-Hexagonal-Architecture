package com.springboothexagonal.task.application.mapper.dto;

import com.springboothexagonal.task.domain.entities.dto.TaskDTO;
import com.springboothexagonal.task.domain.entities.model.Task;
import com.springboothexagonal.task.infrastructure.entities.dto.SpringTaskDTO;

public class TaskDTOMapper {

    public TaskDTO toTaskDTO(Task task){

        return new TaskDTO(

                task.getTaskUuid(),
                task.getTitle(),
                task.getDescription()
        );
    }

    public SpringTaskDTO toSpringDTO(TaskDTO taskDTO){

        return new SpringTaskDTO(

                taskDTO.taskUuid(),
                taskDTO.title(),
                taskDTO.description()
        );
    }
}