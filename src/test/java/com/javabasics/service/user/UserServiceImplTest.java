package com.javabasics.service.user;
import com.javabasics.repository.entity.UserEntity;
import com.javabasics.repository.user.JdbcUserDao;
import com.javabasics.repository.user.UserDao;
import com.javabasics.service.user.model.User;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
public class UserServiceImplTest
{
    private UserDao userDao=new JdbcUserDao();
    private UserService userService=new UserServiceImpl(userDao);
    private UserEntity userEntity=new UserEntity();
    @Test
    public void idIsNotNullAfterSaving()
    {
        User user=new User();
        user.name="John2" + System.currentTimeMillis();
        user.password="12345678";
        Long id=userService.save(user);
        assertTrue(id!=null);
    }
    @Test
    public void userIsEqualUserAfterSaving() {
        User user=new User();
        user.name="John2" + System.currentTimeMillis();
        user.password="12345678";
        Long id=userService.save(user);
        User returnedUser = userService.findById(id);
        assertEquals(user, returnedUser);
    }
    @Test
    public void userIsNotNullAfterFinding()
    {
        User user = new User();
        user.name="John2" + System.currentTimeMillis();
        user.password="12345678";
        userService.save(user);
        User returnedUser=userService.findByNameAndPassword(user.name,user.password);
        assertEquals(user, returnedUser);
    }
}