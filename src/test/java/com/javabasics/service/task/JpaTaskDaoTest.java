package com.javabasics.service.task;

import com.javabasics.repository.entity.TaskEntity;
import com.javabasics.repository.task.JpaTaskDao;
import com.javabasics.repository.task.TaskDao;
import com.javabasics.service.task.model.Task;
import com.javabasics.service.user.model.User;
import org.junit.Test;
import junit.framework.TestCase.*;

import static junit.framework.TestCase.assertTrue;

public class JpaTaskDaoTest {
    TaskDao jpaTaskDao=new JpaTaskDao();
    @Test
    public void checkReturnedIdAfterSaving()
    {
        TaskEntity taskEntity=new TaskEntity();
        taskEntity.name="Dont forget";
        taskEntity.userId=1L;
        Long taskId=jpaTaskDao.save(taskEntity);
        assertTrue(taskId!=null && taskId!=0);
    }
}
