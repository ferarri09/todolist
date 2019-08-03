package com.javabasics.service;

import com.javabasics.service.Model.Task;

public interface TaskService {
    Long save(Task task);
    Task findById(Long id);
}
