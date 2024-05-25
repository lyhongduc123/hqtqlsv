package com.example.hqtqlsv.Model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

public class AccountActivity {
    public static final int EMPTY_USERNAME = 0;
    public static final int USERNAME_NOT_EXIST = 1;
    public static final int LOGIN_FAILED = 2;
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

    public static int login(String inputUsername, String inputPassword) {
        if (inputUsername == null || inputUsername.length() == 0) {
            System.out.println("login failed");
            return EMPTY_USERNAME;
        }

        Statement stmt = null;
        try {
            stmt = DBConnection.getConnection().createStatement();
            String query = "SELECT * FROM users WHERE username = " + '\'' + inputUsername + '\'' +
                    "AND password = \'" + inputPassword + '\'' + ";";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println("login successfully");
                User.init(queryStudent(rs.getString("username")));
                return LOGIN_SUCCESS;
            }
            stmt.close();
            System.out.println("login failed");
            return LOGIN_FAILED;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return STATEMENT_ERROR;
    }

    public static boolean changeProfile(String username) {
        return true;
    }

    public static Student queryStudent(String username) {
        return new Student(1000, "bangvoip673", "bangvoip",
                true,  "Nghe An", "To Huu Bang");
    }
}
