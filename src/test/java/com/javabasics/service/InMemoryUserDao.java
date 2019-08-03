package com.javabasics.service;

import com.javabasics.repository.Entity.TaskEntity;
import com.javabasics.repository.Entity.UserEntity;
import com.javabasics.repository.UserDao;

import java.util.HashMap;
import java.util.Map;

public class InMemoryUserDao implements UserDao {
    private Map<Long,UserEntity> users =new HashMap<>();
    private Long id=0L;
    @Override
    public Long save(UserEntity user) {
        users.put(++id,user);
        return id;
    }

    @Override
    public UserEntity findById(Long id) {
        return users.get(id);
    }
}
