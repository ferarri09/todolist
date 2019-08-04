package com.javabasics.repository;

import com.javabasics.repository.Entity.TaskEntity;
import com.javabasics.repository.Entity.UserEntity;
import com.javabasics.service.Model.User;

public interface UserDao {
    public Long save(UserEntity user);
    public UserEntity findById(Long id);
    public UserEntity findByNameAndPassword(String name,String password);
}
