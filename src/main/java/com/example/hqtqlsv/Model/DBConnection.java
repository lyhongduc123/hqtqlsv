package com.example.hqtqlsv.Model;

import java.sql.*;
public class DBConnection {
    private static Connection connection;

    private DBConnection() {}

    static {
        String url = "jdbc:mysql://localhost:3306/hqt";
        String username = "root";
        String password = "123456789";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection(url, username, password);
            System.out.println("success to connect");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("unable to connect");
        }
    }

    public synchronized static Connection getConnection() {
        return connection;
    }

    public static void main(String[] args) {

    }
}
