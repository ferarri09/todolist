package com.javabasics.service.task;
import com.javabasics.connection.ConnectionFactory;
import com.javabasics.repository.task.JdbcTaskDao;
import com.javabasics.repository.task.TaskDao;
import com.javabasics.repository.user.JdbcUserDao;
import com.javabasics.repository.user.UserDao;
import com.javabasics.service.task.model.Task;
import com.javabasics.service.user.UserService;
import com.javabasics.service.user.UserServiceImpl;
import com.javabasics.service.user.model.User;
import org.junit.Test;
import java.sql.Connection;
import java.util.List;
import static junit.framework.TestCase.assertTrue;
public class TaskServiceImplTest {
    private TaskDao taskDao=new JdbcTaskDao();
    private TaskService taskService=new TaskServiceImpl(taskDao);
    private UserDao userDao=new JdbcUserDao();
    private UserService userService=new UserServiceImpl(userDao);
    @Test
    public void checkReturnedIdAfterSaving() {
        User user=new User();
        user.name="John2" + System.currentTimeMillis();
        user.password="12345678";
        Long id=userService.save(user);
        Task task=new Task();
        task.name="Dont forget";
        task.userId=id;
        Long taskId=taskService.save(task);
        assertTrue(taskId!=null && taskId!=0);
    }
    @Test
    public void listIsNotNullAfterFindingByUserId()
    {
        Task task=new Task();
        task.name="Dont forget";
        task.userId=1L;
        taskService.save(task);
        List<Task> tasks=taskService.findByUserId(task.userId);
        assertTrue(!tasks.isEmpty());

    }
    @Test
    public void testConnection() {
        Connection connection = ConnectionFactory.getConnection();
        assertTrue(connection != null);
    }
}