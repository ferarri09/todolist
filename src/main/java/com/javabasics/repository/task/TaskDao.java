package com.javabasics.repository.task;

import com.javabasics.repository.entity.TaskEntity;

public interface TaskDao {
    Long save(TaskEntity task);
    TaskEntity findById(Long id);
}
