package com.example.hqtqlsv.Model;

public class Lop {
    private int id;
    private String khoasFk;
    private String tenLop;
    private String giangVien;
    private int maNganhFk;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKhoasFk() {
        return khoasFk;
    }

    public void setKhoasFk(String khoasFk) {
        this.khoasFk = khoasFk;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getGiangVien() {
        return giangVien;
    }

    public void setGiangVien(String giangVien) {
        this.giangVien = giangVien;
    }

    public int getMaNganhFk() {
        return maNganhFk;
    }

    public void setMaNganhFk(int maNganhFk) {
        this.maNganhFk = maNganhFk;
    }

    public Lop(int id, String khoasFk, String tenLop, String giangVien, int maNganhFk) {
        this.id = id;
        this.khoasFk = khoasFk;
        this.tenLop = tenLop;
        this.giangVien = giangVien;
        this.maNganhFk = maNganhFk;
    }
}
