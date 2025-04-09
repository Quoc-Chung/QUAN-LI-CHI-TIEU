package com.example.quanlichitieu.Model;


public class LoiNhac {
    private String moTa;
    private String ngayNhac;

    public LoiNhac(String moTa, String ngayNhac) {
        this.moTa = moTa;
        this.ngayNhac = ngayNhac;
    }

    public String getMoTa() {
        return moTa;
    }

    public String getNgayNhac() {
        return ngayNhac;
    }
}
