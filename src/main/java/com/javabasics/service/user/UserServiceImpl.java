package com.javabasics.service.user;
import com.javabasics.repository.entity.UserEntity;
import com.javabasics.repository.user.UserDao;
import com.javabasics.service.user.model.User;
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public Long save(User user) {
        return userDao.save(convertToUserEntity(user));
    }
    @Override
    public User findById(Long id) {
        UserEntity userEntity = userDao.findById(id);
        return convertToUser(userEntity);
    }
    @Override
    public User findByNameAndPassword(String name, String password) {
        return convertToUser(userDao.findByNameAndPassword(name, password).get(1));
    }
    private UserEntity convertToUserEntity(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.name = user.name;
        userEntity.password = user.password;
        return userEntity;
    }
    private User convertToUser(UserEntity userEntity) {
        User user = new User();
        user.id=userEntity.id;
        user.name = userEntity.name;
        user.password = userEntity.password;
        return user;
    }
}