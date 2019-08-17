package com.javabasics.repository.user;
import com.javabasics.connection.ConnectionFactory;
import com.javabasics.repository.entity.UserEntity;
import java.sql.*;
public class JdbcUserDao implements UserDao {
    private Connection connection = ConnectionFactory.getConnection();
    @Override
    public Long save(UserEntity userEntity) {
        ResultSet rs = null;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("insert into user(name,password) values(?,?)");
            statement.setString(1, userEntity.name);
            statement.setString(2, userEntity.password);
            statement.execute();
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
        UserEntity userEntity=new UserEntity();
        PreparedStatement statement=null;
        try {
            statement=connection.prepareStatement("select * from user where id = ?");
            statement.setLong(1,id);
            ResultSet rs = statement.executeQuery();
            if(rs.next())
            {
                userEntity.id=rs.getLong(1);
                userEntity.name=rs.getString(2);
                userEntity.password=rs.getString(3);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userEntity;
    }
    @Override
    public UserEntity findByNameAndPassword(String name, String password) {
        UserEntity userEntity=new UserEntity();
        PreparedStatement statement=null;
        try {
            statement=connection.prepareStatement("select * from user where name=? and password=?");
            statement.setString(1,name);
            statement.setString(2,password);
            ResultSet rs = statement.executeQuery();
            if(rs.next())
            {
                userEntity.id=rs.getLong(1);
                userEntity.name=rs.getString(2);
                userEntity.password=rs.getString(3);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userEntity;
    }
}
