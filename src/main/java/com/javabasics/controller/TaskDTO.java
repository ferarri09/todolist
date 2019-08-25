package com.javabasics.controller;

import com.javabasics.service.task.model.Task;

public class TaskDTO
{
    public String name;
    public Long userId;
    public void setTaskDto(Task task)
    {
        name=task.name;
        userId=task.userId;
    }
}

