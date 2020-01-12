package com.example.coinmanage;

public class ChiTieu {
    private int id;
    private String mieuTaChiTieu;
    private int tienChiTieu;
    private String phanLoai;

    public String getPhanLoai() {
        return phanLoai;
    }

    public void setPhanLoai(String phanLoai) {
        this.phanLoai = phanLoai;
    }

    public int getTienChiTieu() {
        return tienChiTieu;
    }

    public void setTienChiTieu(int tienChiTieu) {
        this.tienChiTieu = tienChiTieu;
    }

    public String getMieuTaChiTieu() {
        return mieuTaChiTieu;
    }

    public void setMieuTaChiTieu(String mieuTaChiTieu) {
        this.mieuTaChiTieu = mieuTaChiTieu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ChiTieu(){}
    public ChiTieu(int id,String mieuta, int tien, String phanloai)
    {
        this.id=id;
        mieuTaChiTieu=mieuta;
        tienChiTieu=tien;
        phanLoai=phanloai;
    }
}
