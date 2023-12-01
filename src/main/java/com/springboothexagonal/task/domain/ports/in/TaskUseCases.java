package com.springboothexagonal.task.domain.ports.in;

import com.springboothexagonal.task.domain.entities.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskUseCases {

    List<Task> selectAllTasks();
    Task insertTask(Task task);
    Optional<Task> selectTaskById(Long taskId);
    Optional<Task> selectTaskByUuid(String taskUuid);
    void deleteTaskById(Long taskId);
    void deleteByTaskUuid(String taskUuid);
    boolean existsTaskById(Long taskId);
    boolean existsTaskByUuid(String taskUuid);
}