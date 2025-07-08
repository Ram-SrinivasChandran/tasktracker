package com.ram.tasktracker.controller;

import com.ram.tasktracker.Entity.Task;
import com.ram.tasktracker.service.TaskService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/task")
@RequiredArgsConstructor
@Slf4j
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        log.info("Received request to create task with title: {}", task.getTitle());
        Task createdTask = taskService.createTask(task);
        log.info("Task created with ID: {}", task.getId());
        return createdTask;
    }

}
