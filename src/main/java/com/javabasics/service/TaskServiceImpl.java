package com.javabasics.service;

import com.javabasics.repository.TaskRepository;
import com.javabasics.repository.TaskRepositoryImpl;
import com.javabasics.service.Model.Task;

public class TaskServiceImpl implements TaskService
{
    private TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Long save(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task findById(Long id) {

        return taskRepository.findById(id);
    }
}
