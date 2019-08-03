package com.javabasics.repository;

import com.javabasics.repository.Entity.TaskEntity;
import com.javabasics.repository.Entity.UserEntity;
import com.javabasics.service.Model.Task;
import com.javabasics.service.Model.User;

public class TaskRepositoryImpl implements TaskRepository
{
    private TaskDAO taskDAO;
    private UserDao userDao;
    public TaskRepositoryImpl(TaskDAO taskDAO,UserDao userDao)
    {
        this.taskDAO=taskDAO;
        this.userDao=userDao;
    }
    public Long save(Task task)
    {

        Long insertedUserId=userDao.save(convertToUserEntity(task.user));
        return taskDAO.save(createTaskEntity(task,insertedUserId));
    }

    @Override
    public Task findById(Long id) {
        TaskEntity taskEntity=taskDAO.findById(id);
        UserEntity userEntity=userDao.findById(taskEntity.userId);
        return convertToTask(taskEntity,userEntity);
    }

    private Task convertToTask(TaskEntity taskEntity, UserEntity userEntity) {
        Task task=new Task();
        task.name=taskEntity.name;
        User user=new User();
        user.name=userEntity.name;
        task.user=user;
        return task;
    }

    private TaskEntity createTaskEntity(Task task,Long insertedUserId)
    {
        TaskEntity taskEntity=new TaskEntity();
        taskEntity.name=task.name;
        taskEntity.userId=insertedUserId;
        return taskEntity;
    }
    private UserEntity convertToUserEntity(User user)
    {
        UserEntity userEntity=new UserEntity();
        userEntity.name=user.name;
        return userEntity;
    }
}
