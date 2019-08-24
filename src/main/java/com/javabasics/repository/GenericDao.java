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
import java.util.Map;
import java.util.stream.Collectors;

public class GenericDao<T> {
    private Class<?> entityType;
    private Connection connection = ConnectionFactory.getConnection();

    public GenericDao() {
        entityType = Utils.getGenericTypeClassFromObjectByIndex(this, 0);
    }

    public Long save(T t) {
        ResultSet rs;
        List<String> fieldNames = new ArrayList<>();
        List<String> fieldValues = new ArrayList<>();
        Field[] fields = t.getClass().getDeclaredFields();
        for (Field field : fields) {
            Id idAnnotation = field.getAnnotation(Id.class);
            if (idAnnotation == null) {
                field.setAccessible(true);


                fieldNames.add(getColumnName(field));

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
            statement.executeUpdate("insert into " + getTableName() + "(" + String.join(",", fieldNames) + ") values(" + String.join(",", fieldValues) + ")");
            rs = statement.executeQuery("select LAST_INSERT_ID() as id");
            if (rs.next()) {
                return rs.getLong("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getColumnName(Field field) {
        Column column = field.getAnnotation(Column.class);
        if (column != null) {
            return column.value();
        } else {
            return field.getName();
        }
    }

    public T findById(Long id){
        ResultSet rs;
        Statement statement;
        T t = null;
        try {
            t = (T) entityType.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Field[] fields = entityType.getDeclaredFields();
        try {
            statement=connection.createStatement();
            rs=statement.executeQuery("select * from "+getTableName()+" where id="+id);
            if(rs.next()) {
                for (Field field: fields) {
                    try {
                        field.set(t, rs.getObject(getColumnName(field)));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return t;
    }
    public List<T> findByParameters(Map<String, Object> parameters)
    {
        Field[] fields= entityType.getDeclaredFields();
        List<T> entities=new ArrayList<>();
        String filter=parameters.entrySet()
                .parallelStream()
                .map(entry->entry.getKey()+" = '"+entry.getValue()+"'")
                .collect(Collectors.joining(" and "));
        ResultSet rs;
        Statement statement;
        try {
            statement = connection.createStatement();
            rs = statement.executeQuery("select * from " + getTableName() + " where " + filter);
            while(rs.next())
            {
                T t=(T)entityType.newInstance();
                for(Field field:fields)
                {
                    field.set(t,rs.getObject(getColumnName(field)));
                    entities.add(t);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return entities;
    }
    private String getTableName() {
        Table table = entityType.getAnnotation(Table.class);
        if (table != null) {
            return table.value();
        } else {
            return entityType.getSimpleName();
        }
    }

}