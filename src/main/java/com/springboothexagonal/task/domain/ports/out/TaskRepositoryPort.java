package com.springboothexagonal.task.domain.ports.out;

import com.springboothexagonal.task.domain.entities.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepositoryPort {

    List<Task> findAll();
    Task save(Task task);
    Optional<Task> findByTaskId(Long taskId);
    Optional<Task> findByTaskUuid(String TaskUuid);
    void deleteTaskByTaskId(Long taskId);
    void deleteTaskByTaskUuid(String taskUuid);
    boolean existsTaskByTaskId(Long taskId);
    boolean existsTaskByTaskUuid(String taskUuid);
}