package com.javabasics.repository;

import com.javabasics.connection.ConnectionFactory;
import com.javabasics.repository.Entity.UserEntity;

import java.sql.*;

public class JdbcUserDao implements UserDao {
    private Connection connection = ConnectionFactory.getConnection();

    @Override
    public Long save(UserEntity userEntity) {
        ResultSet rs = null;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("insert into user(name) values(?)");
            statement.setString(1, userEntity.name);
            //statement.executeUpdate(String.format("insert into user(name) values('%s')", userEntity.name));
            // select LAST_INSERT_ID()
            rs = statement.executeQuery("select LAST_INSERT_ID() as id");
            if (rs.next()) {
                return rs.getLong("id");
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException("Error has occurred during saving");
        } finally {
            try {
                statement.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public UserEntity findById(Long id) {
        return null;
    }
}
