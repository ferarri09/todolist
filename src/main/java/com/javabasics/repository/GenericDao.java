package com.javabasics.repository;
import com.javabasics.connection.ConnectionFactory;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class GenericDao<T> {
    Connection connection=ConnectionFactory.getConnection();
    public Long save(T t)
    {
        String tableName=t.getClass().getSimpleName();
        List<String> fieldNames = new ArrayList<>();
        List<String> fieldValues = new ArrayList<>();
        Field[] fields = t.getClass().getDeclaredFields();
        for (Field field: fields) {
            field.setAccessible(true);
            fieldNames.add(field.getName());
            try {
                fieldValues.add(field.get(t).toString());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        Statement statement= null;
        try {
            statement = connection.createStatement();
            return (long) statement.executeUpdate("insert into " + tableName + "(" + String.join(",", fieldNames) + ") values(" + String.join(",", fieldValues) + ")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
