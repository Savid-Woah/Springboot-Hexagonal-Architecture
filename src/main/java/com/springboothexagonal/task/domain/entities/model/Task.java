package com.springboothexagonal.task.domain.entities.model;

import java.util.UUID;

public class Task {

    private Long taskId;
    private String taskUuid = UUID.randomUUID().toString();
    private String title;
    private String description;

    public Task() {
    }

    public Task(
            Long taskId,
            String taskUuid,
            String title,
            String description
    ) {
        this.taskId = taskId;
        this.taskUuid = taskUuid;
        this.title = title;
        this.description = description;
    }

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getTaskUuid() {
        return taskUuid;
    }

    public void setTaskUuid(String taskUuid) {
        this.taskUuid = taskUuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}