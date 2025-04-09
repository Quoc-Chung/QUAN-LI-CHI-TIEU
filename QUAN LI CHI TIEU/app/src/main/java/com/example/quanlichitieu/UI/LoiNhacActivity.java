package com.example.quanlichitieu.UI;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

;
import com.example.quanlichitieu.Adapter.LoiNhacAdapter;
import com.example.quanlichitieu.Model.LoiNhac;
import com.example.quanlichitieu.R;

import java.util.ArrayList;
import java.util.Calendar;

public class LoiNhacActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Button btnTaoLoiNhac;
    private LoiNhacAdapter adapter;
    private ArrayList<LoiNhac> loiNhacsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loinhac_activity);

        recyclerView = findViewById(R.id.recyclerViewLoiNhac);
        btnTaoLoiNhac = findViewById(R.id.btnTaoLoiNhac);

        loiNhacsList = new ArrayList<>();
        adapter = new LoiNhacAdapter(loiNhacsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        btnTaoLoiNhac.setOnClickListener(v -> showDialogTaoLoiNhac());
    }

    private void showDialogTaoLoiNhac() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_them_loi_nhac);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        // Thiết lập kích thước dialog lớn hơn
        Window window = dialog.getWindow();
        if (window != null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.copyFrom(window.getAttributes());
            layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT; // Chiều rộng full màn hình
            layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT; // Chiều cao tự động
            layoutParams.gravity = Gravity.CENTER; // Căn giữa
            window.setAttributes(layoutParams);
        }

        EditText edtMoTa = dialog.findViewById(R.id.edtMoTa);
        EditText edtNgayNhac = dialog.findViewById(R.id.edtNgayNhac);
        ImageView btnChonNgay = dialog.findViewById(R.id.btnChonNgay);
        Button btnHuy = dialog.findViewById(R.id.btnHuy);
        Button btnLuu = dialog.findViewById(R.id.btnLuu);

        btnChonNgay.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view, year1, month1, dayOfMonth) -> {
                String selectedDate = dayOfMonth + "/" + (month1 + 1) + "/" + year1;
                edtNgayNhac.setText(selectedDate);
            }, year, month, day);
            datePickerDialog.show();
        });

        btnHuy.setOnClickListener(v -> dialog.dismiss());

        btnLuu.setOnClickListener(v -> {
            String moTa = edtMoTa.getText().toString().trim();
            String ngayNhac = edtNgayNhac.getText().toString().trim();

            if (moTa.isEmpty() || ngayNhac.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
                return;
            }

            loiNhacsList.add(new LoiNhac(moTa, ngayNhac));
            adapter.notifyDataSetChanged();
            dialog.dismiss();
        });

        dialog.show();
    }

}
