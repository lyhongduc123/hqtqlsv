package com.example.hqtqlsv.Model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

public class AccountActivity {
    public static final int EMPTY_USERNAME = 0;
    public static final int USERNAME_NOT_EXIST = 1;
    public static final int WRONG_PASSWORD = 2;
    public static final int REGISTER_SUCCESS = 3;
    public static final int LOGIN_SUCCESS = 4;
    public static final int STATEMENT_ERROR = 100;

    public static boolean usernameExists(String username) {
        Statement stmt = null;
        try {
            stmt = DBConnection.getConnection().createStatement();
            String query = "SELECT * FROM users WHERE username = " + username + ";";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                return true;
            }
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }
    public static int login(String username, String password) {
        if (username == null || username.length() == 0) {
            System.out.println("login failed");
            return EMPTY_USERNAME;
        }
        if (!usernameExists(username)) {
            System.out.println("login failed");
            return USERNAME_NOT_EXIST;
        }

        Statement stmt = null;
        try {
            stmt = DBConnection.getConnection().createStatement();
            String query = "SELECT * FROM users WHERE username = " + username + ";";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String getPassword = rs.getString("password");
                if (password.equals(getPassword)) {
                    System.out.println("login successfully");
                    return LOGIN_SUCCESS;
                } else {
                    System.out.println("login failed");
                    return WRONG_PASSWORD;
                }
            }
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return STATEMENT_ERROR;
    }

    public static int register(String username, String password) {
        return 0;
    }
}
