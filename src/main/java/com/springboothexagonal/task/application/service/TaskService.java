package com.springboothexagonal.task.application.service;

import com.springboothexagonal.task.application.mapper.dto.TaskDTOMapper;
import com.springboothexagonal.task.application.mapper.request.TaskAddRequestMapper;
import com.springboothexagonal.task.domain.entities.dto.TaskDTO;
import com.springboothexagonal.task.domain.entities.model.Task;
import com.springboothexagonal.task.domain.entities.request.TaskAddRequest;
import com.springboothexagonal.task.domain.ports.in.TaskUseCases;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TaskService {

    private final TaskUseCases taskUseCases;
    private final TaskDTOMapper taskDTOMapper;
    private final TaskAddRequestMapper taskAddRequestMapper;

    public TaskService(
            TaskUseCases taskUseCases,
            TaskDTOMapper taskDTOMapper,
            TaskAddRequestMapper taskAddRequestMapper
    ) {
        this.taskUseCases = taskUseCases;
        this.taskDTOMapper = taskDTOMapper;
        this.taskAddRequestMapper = taskAddRequestMapper;
    }

    public List<TaskDTO> getAllTasks(){

        List<TaskDTO> tasks = taskUseCases.selectAllTasks()
                .stream()
                .map(taskDTOMapper::toTaskDTO)
                .collect(Collectors.toList());

        return tasks;
    }

    public boolean addTask(TaskAddRequest taskAddRequest){

        Task task = taskAddRequestMapper.toTask(taskAddRequest);
        Task savedTask = taskUseCases.insertTask(task);

        if(savedTask != null && savedTask.getTaskId() != null){
            return true;
        }
        else{
            throw new RuntimeException("Server error adding Task");
        }
    }

    public Optional<TaskDTO> getTask(String taskUuid){

        Optional<TaskDTO> task = taskUseCases.selectTaskByUuid(taskUuid)
                .map(taskDTOMapper::toTaskDTO);

        if(task.isPresent()){
            return task;
        }
        else{
            throw new RuntimeException("Server error fetching Task");
        }
    }

    @Transactional
    public boolean deleteTask(String taskUuid){

        boolean existsTask = taskUseCases.existsTaskByUuid(taskUuid);

        if(existsTask){

            taskUseCases.deleteByTaskUuid(taskUuid);

            boolean stillExistsTask = taskUseCases.existsTaskByUuid(taskUuid);

            if(!stillExistsTask){
                return true;
            }
            else{
                throw new RuntimeException("Server error deleting Task");
            }
        }
        else {
            throw new RuntimeException("Task does not exist");
        }
    }
}