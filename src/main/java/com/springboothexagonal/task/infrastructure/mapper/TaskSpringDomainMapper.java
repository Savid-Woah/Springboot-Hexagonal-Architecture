package com.springboothexagonal.task.infrastructure.mapper;

import com.springboothexagonal.task.domain.entities.model.Task;
import com.springboothexagonal.task.infrastructure.entities.model.SpringTask;
import org.springframework.stereotype.Component;

@Component
public class TaskSpringDomainMapper {

    public Task toTask(SpringTask springTask){

        return new Task(

                springTask.getTaskId(),
                springTask.getTaskUuid(),
                springTask.getTitle(),
                springTask.getDescription()
        );
    }

    public SpringTask toSpringTask(Task task){

        return new SpringTask(

                task.getTaskId(),
                task.getTaskUuid(),
                task.getTitle(),
                task.getDescription()
        );
    }
}