package com.javabasics.controller;

import com.javabasics.repository.user.JpaUserDao;
import com.javabasics.service.user.UserService;
import com.javabasics.service.user.UserServiceImpl;
import com.javabasics.service.user.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("todo-list/user")
public class UserController {
    private UserService userService = new UserServiceImpl(new JpaUserDao());

    @PostMapping("save")
    public void save(@RequestBody User user)
    {
        userService.save(user);
    }

    @PostMapping("find-user")
    public User findByNameAndPassword(@RequestBody Credentials credentials)
    {
        return userService.findByNameAndPassword(credentials.name, credentials.password);
    }

}
