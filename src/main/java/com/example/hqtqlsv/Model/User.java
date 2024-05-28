package com.example.hqtqlsv.Model;

import java.time.OffsetDateTime;

public abstract class User {
    private int id;
    private String userName;
    private String password;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }


    protected User(int id, String userName, String password, OffsetDateTime createdAt, OffsetDateTime updatedAt) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    private static User user;

    public synchronized static void init(User user) {
        User.user = user;
    }

    public synchronized static User getInstance() {
        if (user == null) {
            throw new IllegalStateException("User is not initialized");
        }
        return user;
    }

    public void logOut() {
        user = null;
        StudentForShow.setStudent(null);
    }
}
