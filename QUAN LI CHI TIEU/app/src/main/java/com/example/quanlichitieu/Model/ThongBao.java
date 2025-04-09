package com.example.quanlichitieu.Model;

public class ThongBao {
    private int avatar; // Hình ảnh đại diện
    private String noiDung; // Nội dung thông báo

    public ThongBao(int avatar, String noiDung) {
        this.avatar = avatar;
        this.noiDung = noiDung;
    }

    public int getAvatar() {
        return avatar;
    }

    public String getNoiDung() {
        return noiDung;
    }
}

