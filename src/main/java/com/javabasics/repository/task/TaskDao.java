package com.javabasics.repository.task;

import com.javabasics.repository.entity.TaskEntity;
import com.javabasics.service.task.model.Task;

import java.util.List;

public interface TaskDao {
    Long save(TaskEntity task);
    TaskEntity findById(Long id);
    List<TaskEntity> findByUserId(Long userId);
}
