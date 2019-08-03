package com.javabasics.service;

import com.javabasics.repository.Entity.TaskEntity;
import com.javabasics.repository.TaskDAO;

import java.util.HashMap;
import java.util.Map;

public class InMemoryTaskDao implements TaskDAO {
    private Long id=0L;
    private Map<Long, TaskEntity> tasks=new HashMap<>();

    @Override
    public long save(TaskEntity task) {
        tasks.put(++id,task);
        return id;
    }

    @Override
    public TaskEntity findById(Long id) {
        return tasks.get(id);
    }
}
