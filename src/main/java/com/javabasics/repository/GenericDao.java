package com.javabasics.repository;
import com.javabasics.connection.ConnectionFactory;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class GenericDao<T> {
    Connection connection = ConnectionFactory.getConnection();
    public Long save(T t) {
        ResultSet rs;
        String tableName = t.getClass().getSimpleName();
        List<String> fieldNames = new ArrayList<>();
        List<String> fieldValues = new ArrayList<>();
        Field[] fields = t.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            fieldNames.add(field.getName());
            try {
                fieldValues.add(field.get(t).toString());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("insert into " + tableName + "(" + String.join(",", fieldNames) + ") values(" + String.join(",", fieldValues) + ")");
            rs = statement.executeQuery("select LAST_INSERT_ID() as id");
            if (rs.next()) {
                return rs.getLong("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}