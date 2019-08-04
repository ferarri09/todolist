package com.javabasics.service.task;

import com.javabasics.connection.ConnectionFactory;
import com.javabasics.repository.task.JdbcTaskDao;
import com.javabasics.repository.task.TaskDao;
import org.junit.Test;

import java.sql.Connection;
import static junit.framework.TestCase.assertTrue;

public class TaskServiceImplTest {
    private TaskDao taskDao = new JdbcTaskDao();
    private TaskService taskService = new TaskServiceImpl(taskDao);

    @Test
    public void checkReturnedIdAfterSaving() {

    }



    @Test
    public void testConnection() {
        Connection connection = ConnectionFactory.getConnection();
        assertTrue(connection != null);
    }





}