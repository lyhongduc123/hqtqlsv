package com.example.hqtqlsv.Model;

public class Khoas {
    private int khoas;
    private String tenKhoa;

    public int getKhoas() {
        return khoas;
    }

    public void setKhoas(int khoas) {
        this.khoas = khoas;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    public Khoas(int khoas, String tenKhoa) {
        this.khoas = khoas;
        this.tenKhoa = tenKhoa;
    }
}
