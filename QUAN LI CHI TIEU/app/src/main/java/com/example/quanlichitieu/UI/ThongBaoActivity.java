package com.example.quanlichitieu.UI;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlichitieu.Adapter.ThongBaoAdapter;
import com.example.quanlichitieu.Model.ThongBao;
import com.example.quanlichitieu.R;

import java.util.ArrayList;
import java.util.List;

public class ThongBaoActivity extends AppCompatActivity {
    private RecyclerView recyclerViewThongBao;
    private ThongBaoAdapter adapter;
    private ImageView btnMoreOptions;
    private List<ThongBao> thongBaoList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thong_bao_activity);

        btnMoreOptions = findViewById(R.id.btnMoreOptions);
        recyclerViewThongBao = findViewById(R.id.recyclerViewThongBao);
        recyclerViewThongBao.setLayoutManager(new LinearLayoutManager(this));

        // Khởi tạo danh sách thông báo
        thongBaoList = new ArrayList<>();
        thongBaoList.add(new ThongBao(R.drawable.ic_avatar_1, "Bạn còn thiếu một chút tiền từ Phan Khánh Ẩn"));
        thongBaoList.add(new ThongBao(R.drawable.ic_avatar_2, "Bạn hạn trả tiền vay cho Hứa Linh Phong"));
        thongBaoList.add(new ThongBao(R.drawable.ic_avatar_3, "Bạn còn thiếu một chút tiền từ Mai Nguyên"));
        thongBaoList.add(new ThongBao(R.drawable.ic_avatar_4, "Bạn còn thiếu một chút tiền từ Nguyễn Ẩn"));
        thongBaoList.add(new ThongBao(R.drawable.ic_avatar_5, "Bạn còn thiếu một chút tiền từ Lý Tuấn An"));

        // Gán adapter cho RecyclerView
        adapter = new ThongBaoAdapter(thongBaoList);
        recyclerViewThongBao.setAdapter(adapter);

        btnMoreOptions.setOnClickListener(v -> {
            NotificationBottomSheetFragment bottomSheet = new NotificationBottomSheetFragment();
            bottomSheet.show(getSupportFragmentManager(), bottomSheet.getTag());
        });

    }
}
