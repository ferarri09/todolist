package com.javabasics.service.task;

import com.javabasics.repository.entity.TaskEntity;
import com.javabasics.repository.task.JpaTaskDao;
import com.javabasics.repository.task.TaskDao;
import com.javabasics.repository.user.JpaUserDao;
import com.javabasics.repository.user.UserDao;
import com.javabasics.service.user.UserService;
import com.javabasics.service.user.UserServiceImpl;
import com.javabasics.service.user.model.User;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class JpaTaskDaoTest {
    private TaskDao taskDao=new JpaTaskDao();
    private UserDao userDao=new JpaUserDao();
    private UserService userService=new UserServiceImpl(userDao);
    @Test
    public void checkReturnedIdAfterSaving()
    {
        User user=new User();
        user.name="name"+System.currentTimeMillis();
        user.password="12345678";
        Long id=userService.save(user);
        TaskEntity taskEntity=new TaskEntity();
        taskEntity.name="Dont forget";
        taskEntity.userId=id;
        Long taskId=taskDao.save(taskEntity);
        assertTrue(taskId!=null && taskId!=0);
    }
    @Test
    public void taskIsNotNullAfterFinding()
    {
        User user=new User();
        user.name="name"+System.currentTimeMillis();
        user.password="12345678";
        Long userId=userService.save(user);
        TaskEntity taskEntity=new TaskEntity();
        taskEntity.name="Dont forget";
        taskEntity.userId=userId;
        Long taskId=taskDao.save(taskEntity);
        TaskEntity returnedTaskEntity=taskDao.findById(taskId);
        assertEquals(taskEntity,returnedTaskEntity);
    }
    @Test
    public void taskIsEqualTaskAfterFindingByUserId()
    {
        List<TaskEntity> tasks;
        User user=new User();
        user.name="name"+System.currentTimeMillis();
        user.password="12345678";
        Long userId=userService.save(user);
        TaskEntity taskEntity1=new TaskEntity();
        taskEntity1.name="Dont forget";
        taskEntity1.userId=userId;
        TaskEntity taskEntity2=new TaskEntity();
        taskEntity2.name="Dont forget2";
        taskEntity2.userId=userId;
        taskDao.save(taskEntity1);
        taskDao.save(taskEntity2);
        tasks=taskDao.findByUserId(userId);
        assertTrue(tasks.size()>=2);
    }
}
