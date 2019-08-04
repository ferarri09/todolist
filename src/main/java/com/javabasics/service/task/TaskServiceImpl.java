package com.javabasics.service.task;

import com.javabasics.repository.entity.TaskEntity;
import com.javabasics.repository.task.TaskDao;
import com.javabasics.service.task.model.Task;

public class TaskServiceImpl implements TaskService
{
    private TaskDao taskDao;

    public TaskServiceImpl(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @Override
    public Long save(Task task) {
        return taskDao.save(taskToTaskEntity(task));
    }

    @Override
    public Task findById(Long id) {

        return taskEntityToTask(taskDao.findById(id));
    }
    private Task taskEntityToTask(TaskEntity taskEntity)
    {
        Task task=new Task();
        task.id=taskEntity.id;
        task.name=taskEntity.name;
        task.userId=taskEntity.userId;
        return task;
    }
    private TaskEntity taskToTaskEntity(Task task)
    {
        TaskEntity taskEntity=new TaskEntity();
        taskEntity.id=task.id;
        taskEntity.name=task.name;
        taskEntity.userId=task.userId;
        return taskEntity;
    }
}
