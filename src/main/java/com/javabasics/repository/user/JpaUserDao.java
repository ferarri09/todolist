package com.javabasics.repository.user;

import com.javabasics.repository.GenericDao;
import com.javabasics.repository.entity.UserEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JpaUserDao extends GenericDao<UserEntity> implements UserDao {
    @Override
    public List<UserEntity> findByNameAndPassword(String name, String password) {
        Map<String,Object> params=new HashMap<>();
        params.put("name",name);
        params.put("password",password);
        return findByParameters(params);
    }
}
