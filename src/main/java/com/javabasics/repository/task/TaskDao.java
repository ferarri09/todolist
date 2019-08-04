package com.javabasics.repository.task;

import com.javabasics.repository.entity.TaskEntity;
import com.javabasics.service.task.model.Task;

public interface TaskDao {
    Long save(TaskEntity task);
    TaskEntity findById(Long id);
    TaskEntity findByUserId(Long userId);
}
