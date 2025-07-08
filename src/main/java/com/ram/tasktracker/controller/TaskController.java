package com.ram.tasktracker.controller;

import com.ram.tasktracker.Entity.Task;
import com.ram.tasktracker.service.TaskService;
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

    @PutMapping("/{task-id}")
    public Task updateTask(@PathVariable("task-id") Long taskId, @RequestBody Task task) {
        log.info("Received request to update task with ID: {}", taskId);
        Task updatedTask = taskService.updateTask(taskId, task);
        log.info("Task updated with ID: {}", updatedTask.getId());
        return updatedTask;
    }

    @DeleteMapping("/{task-id}")
    public void deleteTask(@PathVariable("task-id") Long taskId) {
        log.info("Task with ID: {} found, proceeding to delete", taskId);
        taskService.deleteTask(taskId);
        log.info("Task with ID: {} deleted successfully", taskId);
    }

}
