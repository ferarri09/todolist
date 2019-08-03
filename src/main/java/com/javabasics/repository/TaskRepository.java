package com.javabasics.repository;

import com.javabasics.service.Model.Task;

public interface TaskRepository {
    public Long save(Task task);
    public Task findById(Long id);

}
