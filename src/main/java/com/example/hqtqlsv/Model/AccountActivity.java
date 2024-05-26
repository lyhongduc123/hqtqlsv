package com.example.hqtqlsv.Model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.OffsetDateTime;

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
                if (User.getInstance() == null) {
                    System.err.println("cant init user");
                    return LOGIN_FAILED;
                }
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


    //TODO change profile at mysql; false if cant change; true if changed
    public static boolean changeProfile(String username, String hoVaTen, String queQuan, boolean isMale) {
        return false;
    }


    public static Student queryStudent(String username) {
        Statement stmt_sinh_vien =  null;
        Statement stmt_user = null;
        try {
            stmt_sinh_vien = DBConnection.getConnection().createStatement();
            stmt_user = DBConnection.getConnection().createStatement();
            String query_sinh_vien = "SELECT * FROM sinh_vien WHERE mssv = \'" + username + "\';";
            String query_user = "SELECT * FROM users WHERE username = \'" + username + "\';";
            ResultSet rs_sinh_vien = stmt_sinh_vien.executeQuery(query_sinh_vien);
            ResultSet rs_user = stmt_user.executeQuery(query_user);
            while (rs_sinh_vien.next() && rs_user.next()) {
                System.out.println("1");
                int id = rs_user.getInt("id");
                String mssv = username;
                String password = rs_user.getString("password");
                OffsetDateTime createdAt = rs_user.getObject("createdAt", OffsetDateTime.class);
                OffsetDateTime updatedAt = rs_user.getObject("updatedAt", OffsetDateTime.class);
                String hoVaTen = rs_sinh_vien.getString("ho_ten");
                Date ngaySinh = rs_sinh_vien.getDate("ngay_sinh");
                String cccd = rs_sinh_vien.getString("cccd");
                boolean male = rs_sinh_vien.getString("gioi_tinh") == "Nam";
                String ten_lop_fk = rs_sinh_vien.getString("ten_lop_fk");
                String queQuan = rs_sinh_vien.getString("que_quan");
                String email = rs_sinh_vien.getString("email");
                return new Student(id, mssv, password, createdAt, updatedAt, male, queQuan, hoVaTen, ngaySinh,
                        cccd, ten_lop_fk, email);
            }
            stmt_user.close();
            stmt_sinh_vien.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
