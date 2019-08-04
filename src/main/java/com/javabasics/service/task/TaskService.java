package com.javabasics.service.task;

import com.javabasics.service.task.model.Task;

public interface TaskService {
    Long save(Task task);
    Task findById(Long id);
}
