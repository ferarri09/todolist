package com.javabasics.service;
import com.javabasics.repository.entity.UserEntity;
import com.javabasics.repository.user.UserDao;
import java.util.HashMap;
import java.util.List;
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
    @Override
    public List<UserEntity> findByNameAndPassword(String name, String password) {
        return null;
    }
}