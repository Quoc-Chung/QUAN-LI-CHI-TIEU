package com.example.quanlichitieu.UI;

import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quanlichitieu.Adapter.GridAdapter;
import com.example.quanlichitieu.R;

public class NhomGiaoDich extends AppCompatActivity {
    GridView gridView;
    TextView tabChiTieu, tabThuNhap;
    String[] categoryNames = {"Thực phẩm", "Chế độ ăn", "Di chuyển", "Thời trang", "Chế độ uống", "Thú cưng",
            "Giáo dục", "Sức khỏe", "Du lịch", "Giải trí", "Hóa đơn nước", "Hóa đơn điện",
            "Hóa đơn", "Quà tặng", "Thêm"};

    int[] categoryIcons = {R.drawable.ic_food, R.drawable.ic_diet, R.drawable.ic_trafic,
            R.drawable.ic_fashion, R.drawable.ic_drink, R.drawable.ic_pet,
            R.drawable.ic_education, R.drawable.ic_health, R.drawable.ic_travel,
            R.drawable.ic_entertainment, R.drawable.ic_water_bill, R.drawable.ic_electric_bill,
            R.drawable.ic_invoice, R.drawable.ic_gift, R.drawable.more};

    String[] incomeNames = {"Tiền lương", "Tiền thưởng", "Tiền đầu tư", "Tiền khác", "Thêm"};
    int[] incomeIcons = {R.drawable.ic_salary, R.drawable.ic_bonus, R.drawable.ic_investment, R.drawable.ic_other, R.drawable.more};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.nhomgiaodich_activity);
            gridView = findViewById(R.id.gridView);
            tabChiTieu = findViewById(R.id.tab_chi_tieu);
            tabThuNhap = findViewById(R.id.tab_thu_nhap);


            // Bắt sự kiện bấm vào "Chi tiêu"
            tabChiTieu.setOnClickListener(v -> {
                loadData(categoryNames, categoryIcons);
                setTabSelected(tabChiTieu, tabThuNhap);
            });

            // Bắt sự kiện bấm vào "Thu nhập"
            tabThuNhap.setOnClickListener(v -> {
                loadData(incomeNames, incomeIcons);
                setTabSelected(tabThuNhap, tabChiTieu);
            });

            GridAdapter adapter = new GridAdapter(this, categoryNames, categoryIcons);
            gridView.setAdapter(adapter);

            Log.d("DEBUG", "GridView initialized successfully.");
        } catch (Exception e) {
            Log.e("ERROR", "Error in NhomGiaoDich: " + e.getMessage());
        }
    }
    // Hàm load dữ liệu vào GridView
    private void loadData(String[] names, int[] icons) {
        GridAdapter adapter = new GridAdapter(this, names, icons);
        gridView.setAdapter(adapter);
    }

    // Hàm đổi màu nền tab được chọn
    private void setTabSelected(TextView selected, TextView unselected) {
        selected.setBackgroundResource(R.drawable.tab_selected_bg);
        selected.setTextColor(getResources().getColor(R.color.white));

        unselected.setBackgroundResource(android.R.color.transparent);
        unselected.setTextColor(getResources().getColor(R.color.gray));
    }

}