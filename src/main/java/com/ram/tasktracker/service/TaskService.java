package com.ram.tasktracker.service;

import com.ram.tasktracker.Entity.Task;
import com.ram.tasktracker.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
}
