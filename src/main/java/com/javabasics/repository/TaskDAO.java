package com.javabasics.repository;

import com.javabasics.repository.Entity.TaskEntity;
import com.javabasics.service.Model.Task;

public interface TaskDAO {
    public long save(TaskEntity task);
    public TaskEntity findById(Long id);
}
