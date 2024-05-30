package com.example.hqtqlsv.Model;

import java.sql.*;
public class DBConnection {
    private static Connection slave;
    private static Connection master;
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

    public synchronized static Connection getConnection(String type) {
        if (type.toUpperCase().equals("MASTER")) {
            return master;
        } else if (type.toUpperCase().equals("SLAVE")) {
            return slave;
        }
        else {
            System.err.println("Unknown type: " + type);
            return null;
        }
    }

    public static void main(String[] args) {

    }
}
