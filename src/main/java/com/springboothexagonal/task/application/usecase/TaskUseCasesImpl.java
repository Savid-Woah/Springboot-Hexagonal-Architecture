package com.springboothexagonal.task.application.usecase;

import com.springboothexagonal.task.domain.entities.model.Task;
import com.springboothexagonal.task.domain.ports.in.TaskUseCases;
import com.springboothexagonal.task.domain.ports.out.TaskRepositoryPort;

import java.util.List;
import java.util.Optional;

public class TaskUseCasesImpl implements TaskUseCases {

    private final TaskRepositoryPort taskRepositoryPort;

    public TaskUseCasesImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public List<Task> selectAllTasks() {
        return taskRepositoryPort.findAll();
    }

    @Override
    public Task insertTask(Task task) {
        return taskRepositoryPort.save(task);
    }

    @Override
    public Optional<Task> selectTaskById(Long taskId) {
        return taskRepositoryPort.findByTaskId(taskId);
    }

    @Override
    public Optional<Task> selectTaskByUuid(String taskUuid) {
        return taskRepositoryPort.findByTaskUuid(taskUuid);
    }

    @Override
    public void deleteTaskById(Long taskId) {
        taskRepositoryPort.deleteTaskByTaskId(taskId);
    }

    @Override
    public void deleteByTaskUuid(String taskUuid) {
        taskRepositoryPort.deleteTaskByTaskUuid(taskUuid);
    }

    @Override
    public boolean existsTaskById(Long taskId) {
        return taskRepositoryPort.existsTaskByTaskId(taskId);
    }

    @Override
    public boolean existsTaskByUuid(String taskUuid) {
        return taskRepositoryPort.existsTaskByTaskUuid(taskUuid);
    }
}