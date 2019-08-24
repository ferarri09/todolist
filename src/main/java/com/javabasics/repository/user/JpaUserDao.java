package com.javabasics.repository.user;

import com.javabasics.repository.GenericDao;
import com.javabasics.repository.entity.UserEntity;

public class JpaUserDao extends GenericDao<UserEntity> implements UserDao {
    @Override
    public UserEntity findByNameAndPassword(String name, String password) {
        return null;
    }
}
