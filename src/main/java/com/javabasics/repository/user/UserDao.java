package com.javabasics.repository.user;
import com.javabasics.repository.entity.UserEntity;

import java.util.List;

public interface UserDao {
    Long save(UserEntity user);
    UserEntity findById(Long id);
    List<UserEntity> findByNameAndPassword(String name, String password);
}