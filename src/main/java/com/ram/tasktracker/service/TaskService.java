package com.ram.tasktracker.service;

import com.ram.tasktracker.Entity.Task;
import com.ram.tasktracker.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskService {

    private final TaskRepository taskRepository;

    public Task createTask(Task task) {
        log.info("Creating task with title: {}", task.getTitle());
        Task save = taskRepository.save(task);
        log.info("Task created with ID: {}", task.getId());
        return save;
    }

    public List<Task> getTasks() {
        log.info("Entering getTasks ()");
        List<Task> tasks = taskRepository.findAll();
        log.info("Leaving getTasks ()");
        return tasks;
    }

    public Task updateTask(Long taskId, Task task) {
        log.info("Updating task with ID: {}", taskId);
        if (taskRepository.existsById(taskId)) {
            task.setId(taskId);
            Task updatedTask = taskRepository.save(task);
            log.info("Task updated with ID: {}", updatedTask.getId());
            return updatedTask;
        } else {
            log.warn("Task with ID: {} not found", taskId);
            throw new RuntimeException(String.format("Task with ID: %d not found", taskId));
        }
    }

    public void deleteTask(Long taskId) {
        log.info("Deleting task with ID: {}", taskId);
        if (taskRepository.existsById(taskId)) {
            taskRepository.deleteById(taskId);
            log.info("Task with ID: {} deleted successfully", taskId);
        } else {
            log.warn("Task with ID: {} not found, cannot delete", taskId);
            throw new RuntimeException(String.format("Task with ID: %d not found", taskId));
        }
    }
}
