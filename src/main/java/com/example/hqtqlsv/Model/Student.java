package com.example.hqtqlsv.Model;

public class Student extends User {
    private int mssv;
    private boolean male;
    private String queQuan;
    private String hoVaTen;

    public int getMssv() {
        return mssv;
    }

    public void setMssv(int mssv) {
        this.mssv = mssv;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public Student(int id, String userName, String password, boolean male, String queQuan, String hoVaTen) {
        super(id, userName, password);
        this.male = male;
        this.queQuan = queQuan;
        this.hoVaTen = hoVaTen;
    }
}
