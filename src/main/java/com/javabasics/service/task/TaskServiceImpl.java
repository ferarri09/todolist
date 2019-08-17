package com.javabasics.service.task;

import com.javabasics.repository.entity.TaskEntity;
import com.javabasics.repository.task.TaskDao;
import com.javabasics.service.task.model.Task;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Task> findByUserId(Long userId) {
        List<TaskEntity> taskEntities=taskDao.findByUserId(userId);
        List<Task> tasks=new ArrayList<>();
        for(int i=0;i<=taskEntities.size()-1;i++)
        {
            tasks.add(taskEntityToTask(taskEntities.get(i)));
        }
        return tasks;
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
