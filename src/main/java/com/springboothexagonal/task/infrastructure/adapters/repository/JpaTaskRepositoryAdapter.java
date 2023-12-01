package com.springboothexagonal.task.infrastructure.adapters.repository;

import com.springboothexagonal.task.domain.entities.model.Task;
import com.springboothexagonal.task.domain.ports.out.TaskRepositoryPort;
import com.springboothexagonal.task.infrastructure.entities.model.SpringTask;
import com.springboothexagonal.task.infrastructure.mapper.TaskSpringDomainMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository("TaskJPA")
@RequiredArgsConstructor
public class JpaTaskRepositoryAdapter implements TaskRepositoryPort {

    private final JpaTaskRepository jpaTaskRepository;
    private final TaskSpringDomainMapper taskSpringDomainMapper;

    @Override
    public List<Task> findAll() {
        return jpaTaskRepository.findAll()
                .stream()
                .map(taskSpringDomainMapper::toTask)
                .collect(Collectors.toList());
    }

    @Override
    public Task save(Task task) {

        SpringTask springTask = taskSpringDomainMapper.toSpringTask(task);
        SpringTask savedSpringTask = jpaTaskRepository.save(springTask);
        Task savedTask = taskSpringDomainMapper.toTask(savedSpringTask);

        return savedTask;
    }

    @Override
    public Optional<Task> findByTaskId(Long taskId) {

        Optional<Task> task = jpaTaskRepository.findById(taskId)
                .map(taskSpringDomainMapper::toTask);

        return task;
    }

    @Override
    public Optional<Task> findByTaskUuid(String taskUuid) {

        Optional<Task> task = jpaTaskRepository.findByTaskUuid(taskUuid)
                .map(taskSpringDomainMapper::toTask);

        return task;
    }

    @Override
    public void deleteTaskByTaskId(Long taskId) {
        jpaTaskRepository.deleteById(taskId);
    }

    @Override
    public void deleteTaskByTaskUuid(String taskUuid) {
        jpaTaskRepository.deleteByTaskUuid(taskUuid);
    }

    @Override
    public boolean existsTaskByTaskId(Long taskId) {
        return jpaTaskRepository.existsById(taskId);
    }

    @Override
    public boolean existsTaskByTaskUuid(String taskUuid) {
        return jpaTaskRepository.existsByTaskUuid(taskUuid);
    }
}