package com.javabasics.service;

import com.javabasics.repository.entity.TaskEntity;
import com.javabasics.repository.task.TaskDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTaskDao implements TaskDao {
    private Long id=0L;
    private Map<Long, TaskEntity> tasks=new HashMap<>();

    @Override
    public Long save(TaskEntity task) {
        tasks.put(++id,task);
        return id;
    }

    @Override
    public TaskEntity findById(Long id) {
        return tasks.get(id);
    }

    @Override
    public List<TaskEntity> findByUserId(Long userId) {
        return null;
    }
}
