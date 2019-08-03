package com.javabasics.service;

import com.javabasics.repository.Entity.UserEntity;
import com.javabasics.repository.JdbcUserDao;
import com.javabasics.repository.UserDao;
import com.javabasics.service.Model.User;
import com.javabasics.service.user.UserService;
import com.javabasics.service.user.UserServiceImpl;
import org.junit.Test;
import static junit.framework.TestCase.*;

public class UserServiceImplTest {
    private UserDao userDao=new JdbcUserDao();
    private UserService userService=new UserServiceImpl(userDao);
    private UserEntity userEntity=new UserEntity();
    @Test
    public void idIsNotNullAfterSaving()
    {
        User user=new User();
        user.name="John";
        Long id=userService.save(user);
        assertTrue(id!=null);
    }
}