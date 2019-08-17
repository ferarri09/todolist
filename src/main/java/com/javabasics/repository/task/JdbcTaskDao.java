package com.javabasics.repository.task;
import com.javabasics.connection.ConnectionFactory;
import com.javabasics.repository.entity.TaskEntity;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class JdbcTaskDao implements TaskDao {
    private Connection connection = ConnectionFactory.getConnection();
    @Override
    public Long save(TaskEntity taskEntity) {
        ResultSet rs=null;
        PreparedStatement statement=null;
        try {
            statement = connection.prepareStatement("insert into task(name,user_id) values(?,?)");
            statement.setString(1, taskEntity.name);
            statement.setLong(2, taskEntity.userId);
            statement.execute();
            rs = statement.executeQuery("select LAST_INSERT_ID() as id");
            if (rs.next()) {
                return rs.getLong("id");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error has occurred during saving");
        }

        return null;
    }
    @Override
    public TaskEntity findById(Long id) {
        TaskEntity taskEntity=new TaskEntity();
        PreparedStatement statement=null;
        try {
            statement=connection.prepareStatement("select * from task where id = ?");
            statement.setLong(1,id);
            ResultSet rs = statement.executeQuery();
            if(rs.next())
            {
                taskEntity.id=rs.getLong(1);
                taskEntity.name=rs.getString(2);
                taskEntity.userId=rs.getLong(3);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return taskEntity;
    }
    @Override
    public List<TaskEntity> findByUserId(Long userId) {
        List<TaskEntity> tasks=new ArrayList<>();
        PreparedStatement statement=null;
        try {
            statement=connection.prepareStatement("select id,name from task where user_id = ?");
            statement.setLong(1,userId);
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
                TaskEntity taskEntity=new TaskEntity();
                taskEntity.id=rs.getLong(1);
                taskEntity.name=rs.getString(2);
                taskEntity.userId=userId;
                tasks.add(taskEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }
}