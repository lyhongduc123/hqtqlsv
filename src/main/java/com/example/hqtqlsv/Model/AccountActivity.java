package com.example.hqtqlsv.Model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.OffsetDateTime;

public class AccountActivity {
    public static final int EMPTY_USERNAME = 0;
    public static final int LOGIN_FAILED = 2;
    public static final int LOGIN_SUCCESS = 4;
    public static final int STATEMENT_ERROR = 100;

    public static boolean usernameExists(String username) {
        Statement stmt;
        try {
            stmt = DBConnection.getConnection().createStatement();
            String query = "SELECT * FROM users WHERE username = " + username + ";";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) return true;
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    public static int login(String inputUsername, String inputPassword) {
        if (inputUsername == null || inputUsername.isEmpty()) {
            System.out.println("login failed");
            return EMPTY_USERNAME;
        }

        Statement stmt;
        try {
            stmt = DBConnection.getConnection().createStatement();
            String query = "SELECT * FROM users WHERE username = " + '\'' + inputUsername + '\'' +
                    "AND password = \'" + inputPassword + '\'' + ";";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                System.out.println("login successfully");
                if (!rs.getBoolean("isAdmin")) {
                    User.init(queryStudent(rs.getString("username")));
                } else {
                    User.init(queryAdmin(rs.getString("username")));
                }
                if (User.getInstance() == null) {
                    System.err.println("cant init user");
                    return LOGIN_FAILED;
                }
                System.out.println(User.getInstance().getClass().getSimpleName());
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

    public static Student queryStudent(String username) {
        Statement stmt_sinh_vien;
        Statement stmt_user;
        try {
            stmt_sinh_vien = DBConnection.getConnection().createStatement();
            stmt_user = DBConnection.getConnection().createStatement();
            String query_sinh_vien = "SELECT * FROM sinh_vien WHERE mssv = \'" + username + "\';";
            String query_user = "SELECT * FROM users WHERE username = \'" + username + "\';";
            ResultSet rs_sinh_vien = stmt_sinh_vien.executeQuery(query_sinh_vien);
            ResultSet rs_user = stmt_user.executeQuery(query_user);
            if (rs_sinh_vien.next() && rs_user.next()) {
                int id = rs_user.getInt("id");
                String password = rs_user.getString("password");
                OffsetDateTime createdAt = rs_user.getObject("createdAt", OffsetDateTime.class);
                OffsetDateTime updatedAt = rs_user.getObject("updatedAt", OffsetDateTime.class);
                String hoVaTen = rs_sinh_vien.getString("ho_ten");
                Date ngaySinh = rs_sinh_vien.getDate("ngay_sinh");
                String cccd = rs_sinh_vien.getString("cccd");
                boolean male = rs_sinh_vien.getString("gioi_tinh").equals("Nam");
                String ten_lop_fk = rs_sinh_vien.getString("ten_lop_fk");
                String queQuan = rs_sinh_vien.getString("que_quan");
                String email = rs_sinh_vien.getString("email");
                return new Student(id, username, password, createdAt, updatedAt, male, queQuan, hoVaTen, ngaySinh,
                        cccd, ten_lop_fk, email);
            }
            stmt_user.close();
            stmt_sinh_vien.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println("cant query for student from database");
        throw new IllegalStateException("cant query for student from database");
    }

    private static User queryAdmin(String username) {
        Statement stmt_user;
        try {
            stmt_user = DBConnection.getConnection().createStatement();
            String query = "SELECT * FROM users WHERE username = \'" + username + "\';";
            ResultSet rs = stmt_user.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                OffsetDateTime createdAt = rs.getObject("createdAt", OffsetDateTime.class);
                OffsetDateTime updatedAt = rs.getObject("updatedAt", OffsetDateTime.class);
                return new Admin(id, rs.getString("username"), rs.getString("password"),
                        createdAt, updatedAt);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("cant query for admin from database");
        throw new IllegalStateException("cant query for admin from database");
    }

    public static boolean changePassword(String username, String newPassword) {
        Statement stmt;
        try {
            stmt = DBConnection.getConnection().createStatement();
            String query = "UPDATE users SET password = \'" + newPassword + "\' WHERE username = \'" + username + "\';";
            stmt.executeUpdate(query);
            stmt.close();
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    public static void logOut() {
        User.getInstance().logOut();
    }

    public static boolean deleteStudent(String mssv) {
        Statement stmt;
        try {
            stmt = DBConnection.getConnection().createStatement();
            String query = "DELETE FROM sinh_vien WHERE mssv = \'" + mssv + "\';";
            stmt.executeUpdate(query);
            query = "DELETE FROM users WHERE username = \'" + mssv + "\';";
            stmt.executeUpdate(query);
            stmt.close();
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    public static boolean addStudent(Student student) {
        return false;
    }
}
