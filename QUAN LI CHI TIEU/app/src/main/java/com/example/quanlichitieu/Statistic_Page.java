package com.example.quanlichitieu;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
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
import java.util.Arrays;
import java.util.List;

public class Statistic_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.statistic_page);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        createListview();
        ChangetoUser();
        ChangetoGroup();
    }

    private void createListview() {
        ListView listView = findViewById(R.id.GroupList);

        List<Group> groups = new ArrayList<>();
        groups.add(new Group(1, "A1", R.drawable.caidat, Arrays.asList("Nam", "Linh")));
        groups.add(new Group(2, "A2", R.drawable.more, Arrays.asList("Hà", "Phúc")));
        groups.add(new Group(3, "A3", R.drawable.vitien, Arrays.asList("Minh", "An")));

        GroupAdapter adapter = new GroupAdapter(this, groups);
        listView.setAdapter(adapter);
    }
    public void ChangetoUser() {


        LinearLayout user = findViewById(R.id.User);
        user.setOnClickListener(v -> {
            Intent intent = new Intent(Statistic_Page.this, Chi_Tieu_Statistic.class);
            startActivity(intent);
        });
    }
    public void ChangetoGroup() {
        LinearLayout group = findViewById(R.id.Group);
        group.setOnClickListener(v -> {
            Intent intent = new Intent(Statistic_Page.this, Group_Chi_statistic.class);
            startActivity(intent);
        });
    }
}