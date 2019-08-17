package com.javabasics.service.task;

import com.javabasics.service.task.model.Task;

import java.util.List;

public interface TaskService {
    Long save(Task task);
    Task findById(Long id);
    List<Task> findByUserId(Long userId);
}
