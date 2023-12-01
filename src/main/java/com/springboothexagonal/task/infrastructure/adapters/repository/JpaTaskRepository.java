package com.springboothexagonal.task.infrastructure.adapters.repository;

import com.springboothexagonal.task.infrastructure.entities.model.SpringTask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaTaskRepository extends JpaRepository<SpringTask, Long> {

    Optional<SpringTask> findByTaskUuid(String taskUuid);
    void deleteByTaskUuid(String taskUuid);
    boolean existsByTaskUuid(String taskUuid);
}