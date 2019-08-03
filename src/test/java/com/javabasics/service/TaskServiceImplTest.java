package com.javabasics.service;

import com.javabasics.connection.ConnectionFactory;
import com.javabasics.repository.TaskDAO;
import com.javabasics.repository.TaskRepository;
import com.javabasics.repository.TaskRepositoryImpl;
import com.javabasics.repository.UserDao;
import com.javabasics.service.Model.Task;
import com.javabasics.service.Model.User;
import org.junit.Test;

import java.sql.Connection;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
public class TaskServiceImplTest {
    private UserDao userDao = new InMemoryUserDao();
    private TaskDAO taskDAO = new InMemoryTaskDao();
    private TaskRepository taskRepository=new TaskRepositoryImpl(taskDAO,userDao);
    private TaskService taskService=new TaskServiceImpl(taskRepository);
    @Test
    public void checkReturnedIdAfterSaving()
    {
        Task task=createTask();
        Long insertedId=taskService.save(task);
        assertTrue(isExists(insertedId));
    }
    @Test
    public void findTest()
    {
        Task task=createTask();
        Long insertedId=taskService.save(task);
        assertEquals(task,taskService.findById(insertedId));
    }
    @Test
    public void testConnection()
    {
        Connection connection= ConnectionFactory.getConnection();
        assertTrue(connection!=null);
    }


    private boolean isExists(Long insertedId) {
        return insertedId!=null;
    }
    private Task createTask()
    {
        Task task=new Task();
        task.name="My first task";
        User user=new User();
        user.name="John";
        task.user=user;
        return task;
    }
}