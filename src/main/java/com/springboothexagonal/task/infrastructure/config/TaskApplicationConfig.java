package com.springboothexagonal.task.infrastructure.config;

import com.springboothexagonal.task.application.mapper.dto.TaskDTOMapper;
import com.springboothexagonal.task.application.mapper.request.TaskAddRequestMapper;
import com.springboothexagonal.task.application.service.TaskService;
import com.springboothexagonal.task.application.usecase.TaskUseCasesImpl;
import com.springboothexagonal.task.domain.ports.out.TaskRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskApplicationConfig {

    @Bean
    public TaskService taskService(TaskRepositoryPort taskRepositoryPort){

        return new TaskService(

                new TaskUseCasesImpl(taskRepositoryPort),
                new TaskDTOMapper(),
                new TaskAddRequestMapper()
        );
    }

    @Bean
    public TaskDTOMapper taskDTOMapper(){return new TaskDTOMapper();}

    @Bean
    public TaskAddRequestMapper taskAddRequestMapper(){return new TaskAddRequestMapper();}

}