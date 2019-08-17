package com.javabasics.repository;

import com.javabasics.connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class GenericDao<T> {
    Connection connection=ConnectionFactory.getConnection();
    public Long save(T t)
    {
        String tableName=t.getClass().getName();
        Map<String,String> keyValues=new HashMap<>();
        keyValues.put();
        Statement statement= null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("insert into $tableName(field1,field2) values('','')");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
