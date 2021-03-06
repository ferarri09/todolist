package com.javabasics.repository.role;
import com.javabasics.connection.ConnectionFactory;
import com.javabasics.repository.entity.RoleEntity;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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

    @Override
    public List<RoleEntity> findAll() {
        PreparedStatement statement=null;
        ResultSet rs=null;
        List<RoleEntity> roleEntities=new ArrayList<>();
        try {
            statement=connection.prepareStatement("select id, name from role");
            rs=statement.executeQuery();
            while(rs.next())
            {
                RoleEntity roleEntity = new RoleEntity(rs.getLong(1), rs.getString(2));
                roleEntities.add(roleEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roleEntities;
    }
}
