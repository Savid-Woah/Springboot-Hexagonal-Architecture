package com.springboothexagonal.task.application.mapper.request;

import com.springboothexagonal.task.domain.entities.model.Task;
import com.springboothexagonal.task.domain.entities.request.TaskAddRequest;
import com.springboothexagonal.task.infrastructure.entities.request.SpringTaskAddRequest;

public class TaskAddRequestMapper {

    public TaskAddRequest toTaskAddRequest(SpringTaskAddRequest springTaskAddRequest){

        return new TaskAddRequest(

                springTaskAddRequest.getTitle(),
                springTaskAddRequest.getDescription()
        );
    }

    public Task toTask(TaskAddRequest taskAddRequest){

        return new Task(

                taskAddRequest.getTitle(),
                taskAddRequest.getDescription()
        );
    }
}