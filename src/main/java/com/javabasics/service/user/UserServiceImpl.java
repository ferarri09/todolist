package com.javabasics.service.user;

import com.javabasics.repository.Entity.UserEntity;
import com.javabasics.repository.UserDao;
import com.javabasics.service.Model.User;

public class UserServiceImpl implements UserService {
    private UserDao userDao;
    public UserServiceImpl(UserDao userDao)
    {
        this.userDao=userDao;
    }
    @Override
    public Long save(User user) {
        return userDao.save(convertToUserEntity(user));
    }

    @Override
    public User findById(Long id) {
        UserEntity userEntity=userDao.findById(id);
        return convertToUser(userEntity);
    }

    private User convertToUser(UserEntity userEntity) {
        User user=new User();
        user.name=userEntity.name;
        return user;
    }

    private UserEntity convertToUserEntity(User user) {
        UserEntity userEntity=new UserEntity();
        userEntity.name=user.name;
        return userEntity;
    }
}
