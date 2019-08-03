package com.javabasics.service;

import com.javabasics.repository.UserDao;
import com.javabasics.service.Model.User;
import com.javabasics.service.user.UserService;
import com.javabasics.service.user.UserServiceImpl;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class UserServiceImplTest {
    private UserDao userDao=new InMemoryUserDao();
    private UserService userService=new UserServiceImpl(userDao);
    @Test
    public void findTest()
    {
        User user=new User();
        user.name="John";
        Long id=userService.save(user);
        assertTrue(id!=null);
    }
}
