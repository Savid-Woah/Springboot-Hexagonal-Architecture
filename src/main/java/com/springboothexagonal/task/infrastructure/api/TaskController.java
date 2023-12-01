package com.springboothexagonal.task.infrastructure.api;

import com.springboothexagonal.task.application.mapper.dto.TaskDTOMapper;
import com.springboothexagonal.task.application.mapper.request.TaskAddRequestMapper;
import com.springboothexagonal.task.application.service.TaskService;
import com.springboothexagonal.task.domain.entities.request.TaskAddRequest;
import com.springboothexagonal.task.infrastructure.entities.request.SpringTaskAddRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@CrossOrigin
@ResponseBody
@RequiredArgsConstructor
@RequestMapping("api/tasks/")
public class TaskController {

    private final TaskService taskService;
    private final TaskDTOMapper taskDTOMapper;
    private final TaskAddRequestMapper taskAddRequestMapper;

    @GetMapping
    public ResponseEntity<?> getAllTasks(){

        return ResponseEntity.ok().body(taskService.getAllTasks().stream().map(taskDTOMapper::toSpringDTO).collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<?> addTask(@Validated @RequestBody SpringTaskAddRequest springTaskAddRequest){

        TaskAddRequest taskAddRequest = taskAddRequestMapper.toTaskAddRequest(springTaskAddRequest);

        if(taskService.addTask(taskAddRequest)){
            return ResponseEntity.status(HttpStatus.CREATED).body("Task created successfully!");
        }
        else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating Task!");
        }
    }

    @GetMapping(path = "{task-uuid}")
    public ResponseEntity<?> getTask(@PathVariable("task-uuid") String taskUuid){
        return ResponseEntity.ok().body(taskService.getTask(taskUuid).map(taskDTOMapper::toSpringDTO));
    }

    @DeleteMapping(path = "{task-uuid}")
    public ResponseEntity<?> deleteTask(@PathVariable("task-uuid") String taskUuid){

        if(taskService.deleteTask(taskUuid)){
            return ResponseEntity.status(HttpStatus.OK).body("Task deleted successfully!");
        }
        else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting Task!");
        }
    }
}