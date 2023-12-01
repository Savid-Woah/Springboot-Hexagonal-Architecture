package com.springboothexagonal.task.domain.entities.request;

public class TaskAddRequest {

    private String title;
    private String description;

    public TaskAddRequest() {
    }

    public TaskAddRequest(String title, String description) {
        this.title = title;
        this.description = description;
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
