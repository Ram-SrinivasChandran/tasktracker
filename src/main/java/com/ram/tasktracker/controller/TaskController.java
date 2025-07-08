package com.ram.tasktracker.controller;

import com.ram.tasktracker.Entity.Task;
import com.ram.tasktracker.service.TaskService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
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

    @GetMapping
    public List<Task> getTasks() {
        log.info("Entering getTasks ()");
        List<Task> tasks = taskService.getTasks();
        log.info("Leaving getTasks ()");
        return tasks;
    }

}
