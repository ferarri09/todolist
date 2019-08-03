package com.javabasics.repository;

import com.javabasics.connection.ConnectionFactory;
import com.javabasics.repository.Entity.UserEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUserDao implements UserDao{
    private Connection connection= ConnectionFactory.getConnection();
    @Override
    public Long save(UserEntity userEntity) {
        try {
            Statement statement=connection.createStatement();
            statement.execute(String.format("insert into user(name) values('%s')",userEntity.name));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public UserEntity findById(Long id) {
        return null;
    }
}
