package com.springboothexagonal.task.infrastructure.entities.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Task")
@Table(name = "tasks")
public class SpringTask {

    @Id
    @GeneratedValue
    @Column(name = "task_id", updatable = false, nullable = false)
    private Long taskId;

    @Column(name = "task_uuid", updatable = false, nullable = false)
    private String taskUuid;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;
}