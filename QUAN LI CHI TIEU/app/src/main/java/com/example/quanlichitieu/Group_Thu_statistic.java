package com.example.quanlichitieu;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class Group_Thu_statistic extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.group_thu_statistic);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initSpinners();
        setBarChart();   // Gọi Bar Chart
        createListview();
        changetoChi();
    }

    private void createListview() {
        ListView listView = findViewById(R.id.GroupList);

        List<User> users = new ArrayList<>();
        users.add(new User("Nam", R.drawable.caidat));
        users.add(new User("Linh", R.drawable.more));
        users.add(new User("Hà", R.drawable.vitien));

        UserAdapter adapter = new UserAdapter(this, users);
        listView.setAdapter(adapter);

    }


    public void setBarChart() {
        BarChart barChart = findViewById(R.id.barChart);

        List<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0, 400000)); // Ăn uống
        entries.add(new BarEntry(1, 250000)); // Di chuyển
        entries.add(new BarEntry(2, 200000)); // Giải trí
        entries.add(new BarEntry(3, 150000)); // Khác

        BarDataSet dataSet = new BarDataSet(entries, "Chi tiêu (VND)");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        dataSet.setValueTextColor(Color.WHITE);
        dataSet.setValueTextSize(12f);

        BarData barData = new BarData(dataSet);
        barChart.setData(barData);

        String[] labels = new String[]{"Ăn uống", "Di chuyển", "Giải trí", "Khác"};
        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(labels));
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1f);
        xAxis.setLabelCount(labels.length);
        xAxis.setTextColor(Color.WHITE);

        barChart.getAxisLeft().setTextColor(Color.WHITE);
        barChart.getAxisRight().setEnabled(false);
        barChart.getLegend().setTextColor(Color.WHITE);
        barChart.getDescription().setEnabled(false);

        barChart.animateY(1000);
        barChart.invalidate();
    }

    private void initSpinners() {
        Spinner typeSpinner = findViewById(R.id.Type);
        Spinner daySpinner = findViewById(R.id.Day);
        Spinner monthSpinner = findViewById(R.id.Month);
        Spinner yearSpinner = findViewById(R.id.Year);

        // Loại chi tiêu
        String[] types = {"Loại", "Ăn uống", "Di chuyển", "Giải trí", "Khác"};
        ArrayAdapter<String> typeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, types);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(typeAdapter);

        // Ngày (1-31)
        List<String> days = new ArrayList<>();
        days.add("Day");
        for (int i = 1; i <= 31; i++) days.add(String.valueOf(i));
        ArrayAdapter<String> dayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, days);
        dayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        daySpinner.setAdapter(dayAdapter);

        // Tháng (1-12)
        List<String> months = new ArrayList<>();
        months.add("Month");

        for (int i = 1; i <= 12; i++) months.add("Tháng " + i);
        ArrayAdapter<String> monthAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, months);
        monthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        monthSpinner.setAdapter(monthAdapter);

        // Năm (ví dụ 2022 - 2025)
        List<String> years = new ArrayList<>();
        years.add("Tất cả");
        for (int i = 2022; i <= 2025; i++) years.add(String.valueOf(i));
        ArrayAdapter<String> yearAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, years);
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yearSpinner.setAdapter(yearAdapter);
    }
    public void changetoChi() {
        Button ThuNhap = findViewById(R.id.ChiTieu);
        ThuNhap.setOnClickListener(v -> {
            Intent intent = new Intent(Group_Thu_statistic.this, Group_Chi_statistic.class);
            startActivity(intent);
        });
    }
}