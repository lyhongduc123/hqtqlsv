package com.example.hqtqlsv.Model;

import java.sql.Date;
import java.time.OffsetDateTime;

public class Student extends User {
    private boolean male;
    private String queQuan;
    private String hoVaTen;
    private Date ngaySinh;
    private String cccd;
    private String ten_lop_fk;
    private String email;

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getTen_lop_fk() {
        return ten_lop_fk;
    }

    public void setTen_lop_fk(String ten_lop_fk) {
        this.ten_lop_fk = ten_lop_fk;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMssv() {
        return getUserName();
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

    public Student(int id, String userName, String password, OffsetDateTime createdAt, OffsetDateTime updatedAt, boolean male, String queQuan, String hoVaTen, Date ngaySinh, String cccd, String ten_lop_fk, String email) {
        super(id, userName, password, createdAt, updatedAt);
        this.male = male;
        this.queQuan = queQuan;
        this.hoVaTen = hoVaTen;
        this.ngaySinh = ngaySinh;
        this.cccd = cccd;
        this.ten_lop_fk = ten_lop_fk;
        this.email = email;
    }
}
