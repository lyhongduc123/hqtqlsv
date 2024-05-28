package com.example.hqtqlsv.Model;

public class SinhVien {
    private String mssv;
    private String hoTen;
    private String ngaySinh;
    private String cccd;
    private String gioiTinh;
    private String tenLop;
    private String queQuan;
    private String email;

    public SinhVien(String mssv, String hoTen, String ngaySinh, String cccd, String gioiTinh, String tenLop, String queQuan, String email) {
        this.mssv = mssv;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.cccd = cccd;
        this.gioiTinh = gioiTinh;
        this.tenLop = tenLop;
        this.queQuan = queQuan;
        this.email = email;
    }

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getters và setters


    @Override
    public String toString() {
        return "SinhVien{" +
                "mssv='" + mssv + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", ngaySinh='" + ngaySinh + '\'' +
                ", cccd='" + cccd + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", tenLop='" + tenLop + '\'' +
                ", queQuan='" + queQuan + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}