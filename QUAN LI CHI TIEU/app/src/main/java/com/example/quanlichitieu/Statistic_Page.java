package com.example.quanlichitieu;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.quanlichitieu.Adapter.GroupAdapter;
import com.example.quanlichitieu.Model.Group;
import com.example.quanlichitieu.UI.Chi_Tieu_Activity;
import com.example.quanlichitieu.UI.Group_Chi_Activity;

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
        groups.add(new Group(1, "A1", R.drawable.ic_avatar_1, Arrays.asList("Nam", "Linh")));
        groups.add(new Group(2, "A2", R.drawable.ic_avatar_2, Arrays.asList("Hà", "Phúc")));
        groups.add(new Group(3, "A3", R.drawable.ic_avatar_3, Arrays.asList("Minh", "An")));

        GroupAdapter adapter = new GroupAdapter(this, groups);
        listView.setAdapter(adapter);
    }
    public void ChangetoUser() {
        LinearLayout user = findViewById(R.id.User);
        user.setOnClickListener(v -> {
            Intent intent = new Intent(Statistic_Page.this, Chi_Tieu_Activity.class);
            startActivity(intent);
        });
    }
    public void ChangetoGroup() {
        LinearLayout group = findViewById(R.id.Group);
        group.setOnClickListener(v -> {
            Intent intent = new Intent(Statistic_Page.this, Group_Chi_Activity.class);
            startActivity(intent);
        });
    }
}