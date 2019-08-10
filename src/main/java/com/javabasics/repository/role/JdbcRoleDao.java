package com.javabasics.repository.role;

import com.javabasics.connection.ConnectionFactory;
import com.javabasics.repository.entity.RoleEntity;
import com.javabasics.repository.entity.TaskEntity;

import java.sql.*;

public class JdbcRoleDao implements RoleDao{
    Connection connection= ConnectionFactory.getConnection();

    @Override
    public Long save(RoleEntity roleEntity) {
        PreparedStatement statement=null;
        ResultSet rs=null;
        try {
            statement=connection.prepareStatement("insert into role(name) value(?)");
            statement.setString(1,roleEntity.name);
            statement.execute();
            rs=statement.executeQuery("select LAST_INSERT_ID() as id");
            if(rs.next())
            {
                return rs.getLong("id");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error has occurred during saving");
        }
        return null;
    }

    @Override
    public RoleEntity findById(Long id) {
        RoleEntity roleEntity=new RoleEntity();
        PreparedStatement statement=null;
        try {
            statement=connection.prepareStatement("select * from role where id = ?");
            statement.setLong(1,id);
            ResultSet rs = statement.executeQuery();
            if(rs.next())
            {
                roleEntity.id=rs.getLong(1);
                roleEntity.name=rs.getString(2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roleEntity;
    }
}