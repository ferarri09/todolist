package com.javabasics.repository;
import com.javabasics.connection.ConnectionFactory;
import com.javabasics.util.Utils;

import java.lang.reflect.Field;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class GenericDao<T> {
    private Class<?> entityType;
    private Connection connection = ConnectionFactory.getConnection();

    public GenericDao() {
        entityType = Utils.getGenericTypeClassFromObjectByIndex(this, 0);
    }

    public Long save(T t) {
        ResultSet rs;
        String tableName = t.getClass().getSimpleName().replace("Entity", "");
        List<String> fieldNames = new ArrayList<>();
        List<String> fieldValues = new ArrayList<>();
        Field[] fields = t.getClass().getDeclaredFields();
        for (Field field : fields) {
            Id idAnnotation = field.getAnnotation(Id.class);
            if (idAnnotation == null) {
                field.setAccessible(true);
                Column column = field.getAnnotation(Column.class);
                if (column != null) {
                    fieldNames.add(column.value());
                } else {
                    fieldNames.add(field.getName());
                }

                try {
                    fieldValues.add("'" + field.get(t) + "'");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
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
    public T findById(Long id){
        ResultSet rs;
        Statement statement;
        String tableName=entityType.getSimpleName().replace("Entity","");
        try {
            statement=connection.createStatement();
            rs=statement.executeQuery("select * from "+tableName+" where id="+id);
            if(rs.next()) {

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}