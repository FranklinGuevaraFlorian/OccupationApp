package com.occupation.app.controller;

import com.occupation.app.DTO.CreateTask;
import com.occupation.app.DTO.ListTask;
import com.occupation.app.model.Task;
import com.occupation.app.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;
    @Autowired
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping("/listTasks")
    public ResponseEntity<Page<ListTask>> listTaskPage(Pageable pageable){
        return ResponseEntity.ok(this.taskService.listTask(pageable));
    }
    @PostMapping("/createTask")
    public ResponseEntity<ListTask> createTask(CreateTask data){
        Task task = this.taskService.createTask(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ListTask(task));
    }
}
