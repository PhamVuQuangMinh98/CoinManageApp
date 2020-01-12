package com.example.coinmanage;

public class No {
    private int id;
    private String mieuTaNo;
    private int tienNo;

    public int getTienNo() {
        return tienNo;
    }

    public void setTienNo(int tienNo) {
        this.tienNo = tienNo;
    }

    public String getMieuTaNo() {
        return mieuTaNo;
    }

    public void setMieuTaNo(String mieuTaNo) {
        this.mieuTaNo = mieuTaNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public No(){}
    public No(int id, String mieuta, int tien)
    {
        this.id=id;
        mieuTaNo=mieuta;
        tienNo=tien;
    }
}
