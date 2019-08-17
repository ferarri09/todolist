package com.javabasics.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionFactory {
    public static Connection getConnection()
    {
        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("driver not found");
        }
        try {
            connection= DriverManager.getConnection("jdbc:mysql://localhost/tasks","root","12345678");
        } catch (SQLException e) {
            throw new RuntimeException("connection not created");
        }
        return connection;
    }
}
