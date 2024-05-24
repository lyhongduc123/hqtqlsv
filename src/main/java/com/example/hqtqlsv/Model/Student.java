package com.example.hqtqlsv.Model;

public class Student extends User {
    private int mssv;
    private boolean male;
    private String queQuan;
    private String hoVaTen;
    public Student(int id, String userName, String password, boolean male, String queQuan, String hoVaTen) {
        super(id, userName, password);
        this.male = male;
        this.queQuan = queQuan;
        this.hoVaTen = hoVaTen;
    }
}
