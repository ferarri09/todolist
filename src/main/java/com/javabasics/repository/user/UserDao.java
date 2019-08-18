package com.javabasics.repository.user;
import com.javabasics.repository.entity.UserEntity;
public interface UserDao {
    public Long save(UserEntity user);
    public UserEntity findById(Long id);
    public UserEntity findByNameAndPassword(String name,String password);
}