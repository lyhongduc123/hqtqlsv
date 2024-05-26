package com.example.hqtqlsv.Model;

public class Nganh {
    private int maNganh;
    private String tenNganh;
    private String maTuyenSinh;

    public int getMaNganh() {
        return maNganh;
    }

    public void setMaNganh(int maNganh) {
        this.maNganh = maNganh;
    }

    public String getTenNganh() {
        return tenNganh;
    }

    public void setTenNganh(String tenNganh) {
        this.tenNganh = tenNganh;
    }

    public String getMaTuyenSinh() {
        return maTuyenSinh;
    }

    public void setMaTuyenSinh(String maTuyenSinh) {
        this.maTuyenSinh = maTuyenSinh;
    }

    public Nganh(int maNganh, String tenNganh, String maTuyenSinh) {
        this.maNganh = maNganh;
        this.tenNganh = tenNganh;
        this.maTuyenSinh = maTuyenSinh;
    }
}
