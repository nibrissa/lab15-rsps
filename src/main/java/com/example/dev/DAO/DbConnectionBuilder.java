package com.example.dev.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionBuilder implements ConnectionBuilder {
    public DbConnectionBuilder() {
        try {
            Class.forName(ConnectionProperty.getProperty("db.driver.class"));
        } catch (ClassNotFoundException ex) {System.out.println(ex.getMessage());}
    }
    @Override
    public Connection getConnection() throws SQLException {
        String url = ConnectionProperty.getProperty("db.url");
        String login = ConnectionProperty.getProperty("db.login");
        String password = ConnectionProperty.getProperty("db.password");
        return DriverManager.getConnection(url, login, password);
    }
}