package com.example.quanlichitieu;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quanlichitieu.UI.Chi_Tieu_Activity;
import com.example.quanlichitieu.UI.Group_Chi_Activity;
import com.example.quanlichitieu.UI.LoiNhacActivity;
import com.example.quanlichitieu.UI.NhomGiaoDich;
import com.example.quanlichitieu.UI.TaiKhoanCuaToiActivity;
import com.example.quanlichitieu.UI.ThongBaoActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, Group_Chi_Activity.class);
        startActivity(intent);
    }
}