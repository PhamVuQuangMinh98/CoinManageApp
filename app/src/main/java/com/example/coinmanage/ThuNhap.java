package com.example.coinmanage;

public class ThuNhap {
    private int id;
    private String mieuTaThuNhap;
    private int tienThuNhap;

    public int getTienThuNhap() {
        return tienThuNhap;
    }

    public void setTienThuNhap(int tienThuNhap) {
        this.tienThuNhap = tienThuNhap;
    }

    public String getMieuTaThuNhap() {
        return mieuTaThuNhap;
    }

    public void setMieuTaThuNhap(String mieuTaThuNhap) {
        this.mieuTaThuNhap = mieuTaThuNhap;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ThuNhap(){}
    public ThuNhap(int id, String mieuTa, int tien)
    {
        this.id=id;
        mieuTaThuNhap=mieuTa;
        tienThuNhap=tien;
    }
}
